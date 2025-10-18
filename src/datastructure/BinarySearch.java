package datastructure;

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

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        ArrayList<Integer> list = new ArrayList<>();

        int[] array = { 34, 84, 15, 0, 2, 99, 79, 9, 88, 89, 18, 31, 39, 100, 101 };

        Node root = null;
        for (int i = 0; i < array.length; i++) {
            root = binarySearch.insert(root, array[i]);
        }

//        binarySearch.inorder_traversal(root, list);

         root = binarySearch.balanceBST(root);

        System.out.println(binarySearch.search(0, root).data);


    }
}
