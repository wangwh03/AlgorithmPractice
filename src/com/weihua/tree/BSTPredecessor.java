package com.weihua.tree;

public class BSTPredecessor {

	public static void main(String[] args) {
	}
	
	/*
	 * If there is a left subtree, then predecessor is the largest number in left subtree
	 * if no left subtree, then predecessor is the parent/ancestor who's right children is the node's parent/ancestor
	 */
	public Node findPredecessor(Node input) {
		if (input.left != null) {
			return findMax(input.left);
		}
		Node tmp = input.parent;
		while (tmp != null && tmp.left == input) {
			input = tmp;
			tmp = tmp.parent;
		}
		
		return tmp;
	}
	
	/*
	 * If there is a right subtree, then predecessor is the smallest number in left subtree
	 * if no left subtree, then predecessor is the parent/ancestor who's left children is the node's parent/ancestor
	 */
	public Node findSuccessor(Node input) {
		if (input.right != null) {
			return findMin(input.right);
		}
		Node tmp = input.parent;
		while (tmp != null && tmp.right == input) {
			input = tmp;
			tmp = tmp.parent;
		}
		
		return tmp;
	}
	
	private Node findMax(Node node) {
		if (node == null) {
			return node;
		}
		while (node.right != null) {
			node = node.right;
		}
		return node;
	}
	
	private Node findMin(Node node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	public static class Node {
		int value;
		Node left;
		Node right;
		Node parent;
	}
}
