package org.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

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

    private Node buildBalancedTreeNode(ArrayList<Integer> nodes, int start, int end ) {

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
    
	public int countNodes(Node root, int count) {

	    if(root == null) return count;
		
	    count++;
	    count = countNodes(root.left, count);
	    count = countNodes(root.right, count);

		return count;
	}
	
	public int medianBst(Node root) {
		int lenNodes = this.countNodes(root, 0);
		int medianPosition = lenNodes % 2 == 1 ? ( lenNodes + 1) / 2 : lenNodes / 2;
		
		AtomicInteger results  = new AtomicInteger(-1);
		
		medianBst(root, medianPosition, new AtomicInteger(), results );
		
		return results.get();
	}
	
	private void medianBst(Node root, int position, AtomicInteger counter, AtomicInteger median) {
		if (root == null)
			return;

			
		medianBst(root.left, position, counter, median);
		counter.getAndIncrement();
		if(counter.get() == position) {
			median.set(root.data);
		}	
		medianBst(root.right, position, counter, median);
	}
	
	private Node getSuccerssor (Node curr) {
		curr = curr.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
	}
	
	public Node delete(Node root, int value) {
		
		if(value < root.data)
			root.left = delete(root.left, value);
		else if(value > root.data)
			root.right = delete(root.right, value);
		else {
			if(root.left == null )  return root.right;
			if(root.right == null)  return root.left;
			
			Node succ = getSuccerssor(root);
			root.data = succ.data;
			root.right = delete(root.right, succ.data);
		}
				
		return root;
	}
}
