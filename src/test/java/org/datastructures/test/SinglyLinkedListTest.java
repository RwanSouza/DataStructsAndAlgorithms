package org.datastructures.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.IntStream;

import org.datastructure.SinglyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SinglyLinkedListTest {

	private SinglyLinkedList linkedList;
	private int[] elements;
	
	@BeforeEach
	public void createLinkedList() {
		this.linkedList = new SinglyLinkedList();
		this.elements = this.createArray(1, 10000);
	}
	
	@Test
	@DisplayName("Should correctly append a new node to the tail of the list")
	void shouldAppendNodeToTail() {
		
		for(int i = 0; i < elements.length;  i++) {
			linkedList.insertToBack(elements[i]);
			assertEquals(elements[i], linkedList.tail());
		}
	}
	
	
	@Test
	@DisplayName("Should correctly append a new node to the tail of the list")
	void shouldAppendNodeToHead() {
		
		for(int i = 0; i < elements.length;  i++) {
			linkedList.insertInFront(elements[i]);
			assertEquals(elements[i], linkedList.head());
		}
	}
	
	@Test
	@DisplayName("should find the value correctly when it exists in the linked list")
	void shouldFindExistingElement() {
		
		for(int i = 0; i < elements.length;  i++) {
			linkedList.insertInFront(elements[i]);
			assertEquals(elements[i], linkedList.head());
		}
		
		assertEquals(50 ,this.linkedList.search(50));
		assertEquals(599 ,this.linkedList.search(599));
		assertEquals(99 ,this.linkedList.search(99));
		assertEquals(null, this.linkedList.search(-999));
		
	}
	
	@Test
	@DisplayName("Should remove the node from the list when a valid value is provided")
	void shouldDeleteNodeFromList() {
		
		for(int i = 0; i < elements.length;  i++) {
			linkedList.insertInFront(elements[i]);
		}
		
		linkedList.delete(1);
		linkedList.delete(10);
		linkedList.delete(10000);
		
		assertEquals(null , this.linkedList.search(1));
		assertEquals(null , this.linkedList.search(10));
		assertEquals(null , this.linkedList.search(10000));
		
		RuntimeException expectedMessage = assertThrows(RuntimeException.class, () -> this.linkedList.delete(1));
		
		assertEquals("No element with value 1 was found in the list", expectedMessage.getMessage());
	}
	
	private int[] createArray(int start, int end) {
		return IntStream.rangeClosed(start, end).boxed().mapToInt(i -> i).toArray();
	}	
}
