package org.datastructures.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;

import org.datastructure.SinglyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SinglyLinkedListTest {

	private SinglyLinkedList linkedList;
	
	@BeforeEach
	public void createLinkedList() {
		this.linkedList = new SinglyLinkedList();
	}
	
	@Test
	@DisplayName("Should correctly append a new node to the tail of the list")
	void shouldAppendNodeToTail() {
		int[] array = this.createArray(1, 10);
		
		for(int i = 0; i < array.length;  i++) {
			linkedList.insertToBack(array[i]);
			assertEquals(array[i], linkedList.tail());
		}
	}
	
	
	@Test
	@DisplayName("Should correctly append a new node to the tail of the list")
	void shouldAppendNodeToHead() {
		int[] array = this.createArray(1, 10);
		
		for(int i = 0; i < array.length;  i++) {
			linkedList.insertInFront(array[i]);
			assertEquals(array[i], linkedList.head());
		}
	}
	
	
	private int[] createArray(int start, int end) {
		return IntStream.rangeClosed(start, end).boxed().mapToInt(i -> i).toArray();
	}	
}
