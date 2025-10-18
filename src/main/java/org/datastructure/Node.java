package org.datastructure;

public class Node {

    public int data;
    public Node left;
    public Node right;

    public Node(Node left, Node right, int data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public Node(int data) {
        this.data = data;
    }
}
