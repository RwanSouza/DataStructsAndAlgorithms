package org.datastructures.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.datastructure.BinarySearch;
import org.datastructure.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {

	private BinarySearch bst;
	private Node root;

	@BeforeEach
	void setup() {
		bst = new BinarySearch();
		root = null;
	}

	@Test
	void shouldInorderTraversalCorrectly() {
		int[] n = { 50, 30, 70, 20, 40, 60, 80 };
		insertValues(n);

		ArrayList<Integer> result = new ArrayList<>();
		bst.inorder_traversal(root, result);
		assertEquals(List.of(20, 30, 40, 50, 60, 70, 80), result);
	}

	@Test
	void shouldPreorderTraversalCorrectly() {
		int[] n = { 100, 200, 20, 10, 30, 150, 300 };

		insertValues(n);

		ArrayList<Integer> result = new ArrayList<>();
		bst.preOrder(root, result);
		assertEquals(List.of(100, 20, 10, 30, 200, 150, 300), result);
	}

	@Test
	void shouldPostorderTraversalCorrectly() {
		int[] values = { 100, 200, 20, 10, 30, 150, 300 };

		insertValues(values);

		ArrayList<Integer> result = new ArrayList<>();
		bst.postOrder(root, result);
		assertEquals(List.of(10, 30, 20, 150, 300, 200, 100), result);
	}

	@Test
	void shouldCountNodesCorrectly() {
		int[] n = { 100, 200, 20, 10, 30, 150, 300 };
		BinarySearch bst = new BinarySearch();

		for (int v : n) {
			root = bst.insert(root, v);
		}

		int countNodes = bst.countNodes(root, 0);
		assertEquals(n.length, countNodes);

	}

	@Test
	void shoudFindMedianInorderTraversalCorrectly() {
		int[] n = { 10, 20, 5, 6, 4, 22, 21, 30, 9, 19, 1, 18, 23 };
		int length = n.length;
		
		insertValues(n);
		
		int medianBst = bst.medianBst(root);
		int indexMedian = length % 2 == 1 ? (length + 1) / 2 : length / 2;
		Arrays.sort(n);
		
		assertEquals(n[indexMedian - 1], medianBst);
		
		
	}

	void insertValues(int[] values) {
		for (int v : values) {
			root = bst.insert(root, v);
		}
	}
}
