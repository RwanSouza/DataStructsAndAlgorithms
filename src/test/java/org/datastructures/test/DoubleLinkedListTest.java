package org.datastructures.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.IntStream;

import org.datastructure.DoubleLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DoubleLinkedListTest {
	
	private DoubleLinkedList linkedList;
	private int[] elements;
	
	@BeforeEach
	public void createLinkedList() {
		this.linkedList = new DoubleLinkedList();
		this.elements = this.createArray(1, 1000);
	}
	
	@Test
	@DisplayName("Should correctly append a new node to the tail of the DoubleLinkedList")
	void shouldAppendNodeToTail() {
		
		for(int element : elements) 
			this.linkedList.insertToBack(element);
		
		assertEquals(1, linkedList.getHead());
		assertEquals(1000, linkedList.getTail());
		Assertions.assertArrayEquals(this.elements, this.linkedList.traverse());
	}
	
	@Test
	@DisplayName("Should correctly append a new node to the tail of the DoubleLinkedList")
	void shouldAppendNodeToHead() {
		for(int element : elements) 
			this.linkedList.insertToFront(element);
		
		assertEquals(1000, linkedList.getHead());
		assertEquals(1, linkedList.getTail());
		reveserArray();
		
		Assertions.assertArrayEquals(elements, this.linkedList.traverse());
	}
	
	@Test
	@DisplayName("Should remove the node from the list when a valid value is provided")
	void shouldDeleteNodeFromList() {
		
		for(int e:elements) {
			linkedList.insertToBack(e);
		}
		
		linkedList.delete(1);
		linkedList.delete(50);
		linkedList.delete(1000);
		
		assertThrows(RuntimeException.class, () -> this.linkedList.delete(1));
		assertThrows(RuntimeException.class, () -> this.linkedList.delete(50));
		assertThrows(RuntimeException.class, () -> this.linkedList.delete(1000));
		
		RuntimeException expectedMessage = assertThrows(RuntimeException.class, () -> this.linkedList.delete(10000));
		assertEquals("No element with value 10.000 was found in the list", expectedMessage.getMessage());
	}
	
	@Test
	@DisplayName("should find the value correctly when it exists in the linked list")
	void shouldFindExistingElement() {
		
		for( int e:elements) {
			linkedList.insertToBack(e);
		}
		
		assertEquals(50 ,this.linkedList.search(50));
		assertEquals(599 ,this.linkedList.search(599));
		assertEquals(99 ,this.linkedList.search(99));
		
	}
	
	private int[] createArray(int start, int end) {
		return IntStream.rangeClosed(start, end).boxed().mapToInt(i -> i).toArray();
	}
	
	private void reveserArray()  {
		this.elements  = IntStream.range(0, elements.length)
                .map(i -> elements[elements.length - 1 - i])
                .toArray();
	}
 }
