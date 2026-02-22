package org.algorithms;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class KLargestElementsFinderTest {

	
	private KLargestElementsFinder kLargestFinder= new KLargestElementsFinder();

	@BeforeEach
	void init() {
		this.kLargestFinder =  new KLargestElementsFinder();
	}
	
	@Test
	@DisplayName("Returns the correct K largest elements for different values of K")	
	void shouldReturnCorrectKLargestElementsForDifferentKValues() {
		List<Integer> data = createData(-1000,1000);
		
		Assertions.assertIterableEquals(IntStream.rangeClosed(998, 1000).boxed().toList(), kLargestFinder.kLargestElements(data, 3));
		Assertions.assertIterableEquals(IntStream.rangeClosed(996, 1000).boxed().toList(), kLargestFinder.kLargestElements(data, 5));
		Assertions.assertIterableEquals(IntStream.rangeClosed(991, 1000).boxed().toList(), kLargestFinder.kLargestElements(data, 10));
		
	}
	
	private static List<Integer> createData(int start, int end) {

		List<Integer> collectionData = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
		Collections.shuffle(collectionData);

		return collectionData;
	}
}
