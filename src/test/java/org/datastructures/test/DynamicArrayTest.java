package org.datastructures.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
		DynamicArray d = new DynamicArray();

		int[] elementsToInsert = IntStream.rangeClosed(1, MAX_ELEMENTS_TO_INSERT).toArray();
		
		for (int e : elementsToInsert)
			dynamicArray.insert(e);

		assertArrayEquals(elementsToInsert, d.getArrayCopy());
	}

	@Test
	void shouldInsertAllElementsAndResizingArrayCorrectly() {
		int[] elementsToInsert = IntStream.rangeClosed(1, MAX_ELEMENTS_TO_INSERT).toArray();

		for (int e : elementsToInsert)
			dynamicArray.insert(e);
		
		final int expectedSize = elementsToInsert.length;
		final int expectedCapacity = calculateCapacity(expectedSize);
		
		assertEquals(expectedCapacity, dynamicArray.getDynamicCapacity());
		assertEquals(expectedSize, dynamicArray.getSize());
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
