package org.datastructures.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.IntStream;

import org.datastructure.Queue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class QueueTest {

	private Queue queue;
	List<Integer> list;
	private final int capacity = 100;

	@BeforeEach
	void init() {
		this.queue = new Queue(capacity);
		this.list = IntStream.rangeClosed(1, capacity).boxed().toList();
	}

	@Test
	@DisplayName("Should add elements into Queue")
	void shouldAddElementsToQueue() {

		for (int n : list)
			queue.enqueue(n);
	}

	@Test
	@DisplayName("Should reset index and dequeue elements in correct order")
	void shouldResetIndexAndDequeueInCorrectOrder() {

		for (int i = 1; i < 120; i++) {

			if (i > 100) {
				Assertions.assertEquals(i - this.capacity, queue.dequeue());
			}
			queue.enqueue(i);
		}
	}

	@Test
	@DisplayName("Throws exception when enqueueing into a full queue")
	void shouldThrowExceptionIfQueueIsFull () {

		for (int n : list)
			queue.enqueue(n);

		RuntimeException message = assertThrows(RuntimeException.class, () -> {
			queue.enqueue(99);
		});

		assertEquals("The queue is already full!", message.getMessage());
	}
	
	@Test
	@DisplayName("Throws exception when dequeueing from an empty queue")
	void shouldThrowExceptionIfQueueIsEmpty() {

		RuntimeException message = assertThrows(RuntimeException.class, () -> {
			queue.dequeue();
		});

		assertEquals("Cannot dequeue from an empty queue", message.getMessage());
	}
	
	@Test
	@DisplayName("Throws exception when queue size is invalid")
	void shouldThrowExceptionWhenSizeIsInvalid() {
		int capacity = 1;
		RuntimeException message = assertThrows(RuntimeException.class, () -> {
			Queue queue2 = new Queue(capacity);
		});

		assertEquals("Invalid size for a queue (must have at least 2 elements): " + capacity, message.getMessage());
	}
}
