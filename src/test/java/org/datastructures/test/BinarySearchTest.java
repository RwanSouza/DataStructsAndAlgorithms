package org.datastructures.test;

import org.datastructure.BinarySearch;
import org.datastructure.Node;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest {

    @Test
     void shouldInsertNodesCorrectly() {
        BinarySearch bst = new BinarySearch();
        Node root = null;

        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int v : values) {
            root = bst.insert(root, v);
        }

        ArrayList<Integer> result = new ArrayList<>();
        bst.inorder_traversal(root, result);
        assertEquals(List.of(20, 30, 40, 50, 60, 70, 80), result);
    }

    @Test
    void shouldPreorderTraversalCorrectly() {
        int[] array = {100, 200, 20, 10, 30, 150, 300};
        BinarySearch bst = new BinarySearch();
        Node root = null;

        for (int v : array) {
            root = bst.insert(root, v);
        }

        ArrayList<Integer> result = new ArrayList<>();
        bst.preOrder(root, result);
        assertEquals(List.of(100, 20, 10, 30, 200, 150, 300), result);
    }

    @Test
    void shouldInorderTraversalCorrectly() {
        int[] array = {100, 200, 20, 10, 30, 150, 300};
        BinarySearch bst = new BinarySearch();
    }

    @Test
    void shouldPostorderTraversalCorrectly() {
        int[] array = {100, 200, 20, 10, 30, 150, 300};
        BinarySearch bst = new BinarySearch();
        Node root = null;

        for (int v : array) {
            root = bst.insert(root, v);
        }

        ArrayList<Integer> result = new ArrayList<>();
        bst.postOrder(root, result);
        assertEquals(List.of(10, 30, 20, 150, 300, 200, 100), result);
    }
}
