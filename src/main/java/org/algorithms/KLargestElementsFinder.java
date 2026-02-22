package org.algorithms;

import java.util.ArrayList;
import java.util.List;

import org.datastructure.PriorityQueue;

public class KLargestElementsFinder {

	public List<Integer> kLargestElements(List<Integer> elements, int k) {
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
