package org.datastructures.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.IntStream;

import org.datastructure.DynamicArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DynamicArrayTest {

	private DynamicArray dynamicArray;
	final int MAX_ELEMENTS_TO_INSERT = 100000;

	@BeforeEach
	public void createDynamicArray() {
		this.dynamicArray = new DynamicArray();
	}

	@Test
	void shouldInsertAllElementsCorrectly() {

		int[] elementsToInsert = IntStream.rangeClosed(1, MAX_ELEMENTS_TO_INSERT).toArray();
		
		for (int e : elementsToInsert)
			dynamicArray.insert(e);

		assertArrayEquals(elementsToInsert, dynamicArray.getArrayCopy());
	}

	@Test
	void shouldInsertAllElementsAndResizingArrayCorrectly() {
		int[] elementsToInsert = IntStream.rangeClosed(1, MAX_ELEMENTS_TO_INSERT).toArray();

		for (int e : elementsToInsert)
			dynamicArray.insert(e);
		
		final int expectedSize = elementsToInsert.length;
		final int expectedCapacity = calculateCapacity(expectedSize);
		
		assertEquals(expectedCapacity, dynamicArray.capacity());
		assertEquals(expectedSize, dynamicArray.getSize());
	}
	
	@Test 
	void shouldDeleteElementsAndReduceSizeCorrectly() {
		int[] elementsToInsert = IntStream.rangeClosed(1, 5).toArray();
		for (int e : elementsToInsert)
			dynamicArray.insert(e);
		
		dynamicArray.delete(4);
		dynamicArray.delete(1);
		dynamicArray.delete(2);
		
		int[] expectedArray = {3,5};
		assertEquals(expectedArray.length, dynamicArray.getSize());
		assertArrayEquals(expectedArray, dynamicArray.getArrayCopy());
	} 
	
	@Test
	void shouldThrowIllegalArgumentExceptionWhenNotFindElement() {
		
		int[] elementsToInsert = IntStream.rangeClosed(1, 5).toArray();
		for (int e : elementsToInsert)
			dynamicArray.insert(e);
		
		IllegalArgumentException isNotInArray = assertThrows(IllegalArgumentException.class, () -> dynamicArray.delete(99));
		
		assertEquals("Unable to delete element 99: the entry is not in the array", isNotInArray.getMessage());
	}

	private static int calculateCapacity(int numberOfElements) {
		if (numberOfElements <= 0) 
			return 0; 
		
		int capacity = 1;
		while (capacity < numberOfElements) 
			capacity = capacity * 2; 
		
		return capacity;
	}
	
}
