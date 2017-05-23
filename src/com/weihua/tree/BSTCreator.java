package com.weihua.tree;

/*
 * Just a util class to create binary search tree
 */
public class BSTCreator {

	public static void main(String[] args) {
		int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
		BSTCreator test = new BSTCreator();
		Node root = test.createBST(array);
		TreeUtils.print(root);
	}

	public Node createBST(int[] input) {
		return createBST(input, 0, input.length - 1);
	}
	
	private Node createBST(int[] input, int left, int right) {
		if (left > right) {
			return null; 
		}
		
		int rootIndex = (left+right) / 2;
		Node root = new Node(input[rootIndex]);
		Node leftChild = createBST(input, left, rootIndex - 1);
		Node rightChild = createBST(input, rootIndex + 1, right);
		root.setLeft(leftChild);
		root.setRight(rightChild);
		
		return root;
	}
}
