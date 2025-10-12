package datastructure;

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

	public void inorder_traversal(Node root) {
		if (root != null) {
			inorder_traversal(root.left);
			System.out.print(" " + root.data);
			inorder_traversal(root.right);
		}
	}

	public Node search(int n, Node root) {
		
		if(root == null) {
			throw new RuntimeException("Number not exists in tree");
		}
		if (n == root.data) {
			return root;
		} else if (n < root.data) {
			root = search(n, root.left);
		} else {
			root = search(n, root.right);
		}
		return root;
	}

	public static void main(String[] args) {
		BinarySearch binarySearch = new BinarySearch();

		int[] array = { 34, 84, 15, 0, 2, 99, 79, 9, 88, 89, 18, 31, 39, 100, 101 };

		Node root = null;
		for (int i = 0; i < array.length; i++) {
			root = binarySearch.insert(root, array[i]);
		}

		Node search = binarySearch.search(99, root);

		System.out.println(search.data + " " + root.data);

//        binarySearch.inorder_traversal(root);
	}
}
