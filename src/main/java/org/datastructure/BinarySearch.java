package org.datastructure;

import java.util.ArrayList;

public class BinarySearch {

    public Node insert(Node root, int data) {
        Node newNode = new Node(null, null, data);
        if (root == null) {

            return newNode;

        } else {
            Node current = root;
            Node parent = current;
            while (true) {
                parent = current;
                if (data < parent.data) {
                    current = parent.left;
                    if (current == null) {
                        parent.left = newNode;
                        return root;
                    }
                } else {
                    current = parent.right;
                    if (current == null) {
                        parent.right = newNode;
                        return root;
                    }
                }
            }
        }
    }

    public void inorder_traversal(Node root, ArrayList<Integer> nodes) {
        if (root != null) {
            inorder_traversal(root.left, nodes);
            nodes.add(root.data);
            inorder_traversal(root.right, nodes);
        }
    }

    public  void preOrder(Node root, ArrayList<Integer> nodes) {
        if(root != null) {
            System.out.print(root.data + " ");
            nodes.add(root.data);
            preOrder(root.left, nodes);
            preOrder(root.right, nodes);

        }
    }

    public void postOrder(Node root, ArrayList<Integer> nodes) {
        if(root != null) {

            postOrder(root.left, nodes);
            postOrder(root.right, nodes);
            nodes.add(root.data);
            System.out.print(root.data + " ");
        }
    }

    public Node search(int n, Node root) {

        if (n < root.data)      return search(n, root.left);
        else if (n > root.data) return search(n, root.right);
        return root;
    }

    public Node buildBalancedTreeNode(ArrayList<Integer> nodes, int start, int end ) {

        if(start > end )
            return null;

        int mid = (start + end ) / 2;

        Node root  =  new Node(nodes.get(mid));
        root.left  =  buildBalancedTreeNode(nodes, start, mid - 1);
        root.right =  buildBalancedTreeNode(nodes, mid  + 1, end);

        return root;
    }

    public Node balanceBST(Node root) {
        ArrayList<Integer> ordered = new ArrayList<>();
        inorder_traversal(root, ordered);

        return buildBalancedTreeNode(ordered, 0, ordered.size() -1);
    }


    public int nodeSum(Node root, int l, int r)  {
        if(root == null) return 0;

        if(root.data < l) {
            return nodeSum(root.right, l, r);
        }
        if(root.data > r) {
            return nodeSum(root.left, l, r);
        }
        int leftSum = nodeSum(root.left, l, r);
        int rightSum = nodeSum(root.right, l, r);

        return leftSum + rightSum + root.data;
    }
}
