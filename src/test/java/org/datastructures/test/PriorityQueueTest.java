package org.datastructures.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.datastructure.PriorityQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PriorityQueueTest {

	private PriorityQueue priorityQueue;

	@BeforeEach
	void init() {
		this.priorityQueue = new PriorityQueue(null, x -> x);
	}

	@Test
	@DisplayName("Maintains max-heap property after insertions")
	void shouldReturnMaxElementFromTop() {

		List<Integer> kLargestElements = kLargestElements(List.of(8, 9, 20, 3, 4, 7, 0, 99), 3);

		IntStream.range(1, 50).boxed().forEach(i -> {
			this.priorityQueue.insert(i);
		});

		IntStream.rangeClosed(1, 49).map(i -> 50 - i).forEach(top -> {
			Assertions.assertEquals(top, this.priorityQueue.top());
		});
	}
	
	
	@Test
	@DisplayName("Maintains min-heap property after insertions")
	void shouldReturnMinxElementFromTop() {

		this.priorityQueue =  new PriorityQueue(null, x -> -x);
		
		IntStream.rangeClosed(1, 50).map(i -> 51 - i).forEach(i -> {
			this.priorityQueue.insert(i);
		});

		IntStream.rangeClosed(1, 50).forEach(top -> {
			Assertions.assertEquals(top, this.priorityQueue.top());
		});
	}
	
	@Test
	@DisplayName("Transforms unordered array into a valid max heap")
	void shouldBuildValidMaxHeapFromUnorderedArray(){
		this.priorityQueue =  new PriorityQueue(createData(100), x -> x);
		
		IntStream.rangeClosed(1, 99).map(i -> 100 - i).forEach(top -> {
			Assertions.assertEquals(top, this.priorityQueue.top());
		});
	}
	
	@Test
	@DisplayName("Transforms unordered array into a valid min heap")
	void shouldBuildValidMinHeapFromUnorderedArray(){
		this.priorityQueue =  new PriorityQueue(createData(100), x -> -x);
		
		IntStream.rangeClosed(1, 99).forEach(top -> {
			Assertions.assertEquals(top, this.priorityQueue.top());
		});
	}
	
	
	
	private static List<Integer> createData(int size) {

		List<Integer> collectionData = IntStream.range(1, size).boxed().collect(Collectors.toList());
		Collections.shuffle(collectionData);

		return collectionData;
	}

	static List<Integer> kLargestElements(List<Integer> elements, int k) {
		PriorityQueue heap = new PriorityQueue(null, x -> -x);
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < elements.size(); i++) {

			if (heap.len() >= k) {

				if (heap.peek() < elements.get(i)) {
					heap.top();
					heap.insert(elements.get(i));
				}
			} else {
				heap.insert(elements.get(i));
			}
		}

		for (int i = 0; i < k; i++) {
			result.add(heap.top());
		}

		return result;
	}

}
