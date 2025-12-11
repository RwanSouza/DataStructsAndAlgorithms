package org.datastructures.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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
	void  shouldInsertPositiveElementsInOrder() {
		 int[] numbersDisordered = createArrayDisordered(1, 1000);
		 
		 for (int e : numbersDisordered)
			 sortedArray.insert(e);
		 
		 assertArrayEquals(IntStream.rangeClosed(1, 1000).toArray(), sortedArray.getArrayCopy());
		 
	}
	
	@Test
	@DisplayName("Insert negatives values into  sortedArray in sorted order")
	void  shouldInsertNegativeElementsInOrder() {
		 int[] numbersDisordered = createArrayDisordered(-1000, -1);
		 
		 for (int e : numbersDisordered)
			 sortedArray.insert(e);
		 
		 assertArrayEquals(IntStream.rangeClosed(-1000, -1).toArray(), sortedArray.getArrayCopy());
		 
	}
	
	@Test
	@DisplayName("Insert negative and positive values into sortedArray in sorted order.")
	void  shouldInsertNegativesAndPositivesElementsInOrder() {
		 int[] numbersDisordered = createArrayDisordered(-500, 499);
		 
		 for (int e : numbersDisordered)
			 sortedArray.insert(e);
		 
		 assertArrayEquals(IntStream.rangeClosed(-500, 499).toArray(), sortedArray.getArrayCopy());
		 
	}

	private int[] createArrayDisordered(int start, int end) {
		List<Integer> elementsList = IntStream.rangeClosed(start, end)
                .boxed() 
                .collect(Collectors.toList());

		Collections.shuffle(elementsList);
		
		return elementsList.stream()
                .mapToInt(i -> i) 
                .toArray();
	}
}
