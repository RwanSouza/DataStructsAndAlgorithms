package org.datastructures.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.datastructure.SortedArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SortedArrayTest {

	private SortedArray sortedArray;

	@BeforeEach
	public void createDynamicArray() {
		this.sortedArray = new SortedArray();
	}

	@Test
	@DisplayName("Insert positives values into sortedArray in sorted order")
	void shouldInsertPositiveElementsInOrder() {
		int[] numbersDisordered = createArrayDisordered(1, 1000);

		insert(numbersDisordered);

		assertArrayEquals(IntStream.rangeClosed(1, 1000).toArray(), sortedArray.getArrayCopy());

	}

	@Test
	@DisplayName("Insert negatives values into  sortedArray in sorted order")
	void shouldInsertNegativeElementsInOrder() {
		int[] numbersDisordered = createArrayDisordered(-1000, -1);

		insert(numbersDisordered);

		assertArrayEquals(IntStream.rangeClosed(-1000, -1).toArray(), sortedArray.getArrayCopy());

	}

	@Test
	@DisplayName("Insert negative and positive values into sortedArray in sorted order.")
	void shouldInsertNegativesAndPositivesElementsInOrder() {
		int[] numbersDisordered = createArrayDisordered(-500, 499);

		insert(numbersDisordered);

		assertArrayEquals(IntStream.rangeClosed(-500, 499).toArray(), sortedArray.getArrayCopy());

	}

	@Test
	@DisplayName("When the array reaches its limit, a RuntimeException is thrown")
	void shouldThrowErrorWhenReachingArrayLimit() {
		RuntimeException overCapacity = assertThrows(RuntimeException.class, () -> {
			int[] numbersDisordered = IntStream.rangeClosed(-500, 502).toArray();

			insert(numbersDisordered);
		});

		assertTrue(overCapacity.getMessage().contains("The array is already full, maximum size"));
	}

	@Test
	@DisplayName("Should return the index when the number exists and a negative value when it does not")
	void shouldReturnIndexWhenNumberExistsAndNegativeOtherwise() {
		int[] numbersDisordered = createArrayDisordered(-20, 20);

		insert(numbersDisordered);

		assertEquals(0, sortedArray.search(-20));
		assertEquals(20, sortedArray.search(0));
		assertEquals(25, sortedArray.search(5));
		assertEquals(-1, sortedArray.search(99));
		assertEquals(-1, sortedArray.search(21));

	}

	@Test
	@DisplayName("Should return the deleted value and shift elements when index is valid")
	void shouldDeleteElementAndShiftArray() {
		int[] numbersDisordered = createArrayDisordered(1, 500);

		insert(numbersDisordered);

		int deletedValue = sortedArray.delete(19);

		assertEquals(20, deletedValue);
		assertEquals(499, sortedArray.getSize());
		assertEquals(19, sortedArray.search(21));
	}

	@Test
	@DisplayName("Should throw RuntimeException when index is -1")
	void shouldThrowExceptionWhenIndexIsNegative() {
		int[] numbersDisordered = createArrayDisordered(1, 500);

		insert(numbersDisordered);
		
		RuntimeException exception = assertThrows(RuntimeException.class, () -> {
			sortedArray.delete(-1);
		});

		assertTrue(exception.getMessage().contains("the entry is not in the array"));
	}

	@Test
	@DisplayName("Should throw RuntimeException when index is greater than maxSize")
	void shouldThrowExceptionWhenIndexIsOutOfBounds() {
		int invalidIndex = 999999; 

		int[] numbersDisordered = createArrayDisordered(1, 500);

		insert(numbersDisordered);
		
		assertThrows(RuntimeException.class, () -> {
			sortedArray.delete(invalidIndex);
		});
	}

	@Test
	@DisplayName("Should find elements and validate logarithmic search steps")
	void shouldFindElementsAndValidateBinarySearchEfficiency() {
		int[] numbersDisordered = createArrayDisordered(-10, 988);
		
		insert(numbersDisordered);
		
		int[] sorted = this.sortedArray.getArrayCopy();
		
		int expectedMaxSteps = (int) Math.ceil(Math.log(this.sortedArray.getSize()) / Math.log(2));
		
		assertEquals(788, sorted[this.sortedArray.binarySearch(788)]);
		assertEquals(expectedMaxSteps, this.sortedArray.getSteps());
		assertEquals(-9, sorted[this.sortedArray.binarySearch(-9)]);
		assertEquals(expectedMaxSteps, this.sortedArray.getSteps());
		assertEquals(-1, this.sortedArray.binarySearch(-11));
	}
	
	private void insert(int[] numbersDisordered) {
		for (int e : numbersDisordered)
			sortedArray.insert(e);
	}

	private int[] createArrayDisordered(int start, int end) {
		List<Integer> elementsList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());

		Collections.shuffle(elementsList);

		return elementsList.stream().mapToInt(i -> i).toArray();
	}
}
