package com.weihua.tree;
import java.util.HashSet;

/**
 * Assume both nodes exist in given tree
 * @author weihua
 */
public class BinaryTreeLCA {

	public static void main(String[] args) {
		BinaryTreeLCA test = new BinaryTreeLCA();
		Node[] trees = test.createTree();
		System.out.println(test.findLowestCommonAncestorWithParentPointer(trees[0], trees[1], trees[2]).value);

		System.out.println(test.findLowestCommonAncestor(trees[0], trees[1], trees[2]).value);
	}

	/*
	 * travel from node1 to root, record all nodes in path
	 * travel from node2 to root, during travel, check if a node is in node1's path
	 * This works when there is parent pointer
	 */
	public Node findLowestCommonAncestorWithParentPointer(Node root, Node node1, Node node2) {
		if (root == null) {
			return null;
		} else if (node1 == null) {
			return node2;
		} else if (node2 == null) {
			return node1;
		}
		
		Node currentNode = node1;
		HashSet<Node> visitedNode = new HashSet<Node>();
		while (currentNode != root) {
			visitedNode.add(currentNode);
			currentNode = currentNode.parent;
		}
		visitedNode.add(root);
		
		currentNode = node2;
		while (currentNode != root && !visitedNode.contains(currentNode)) {
			currentNode = currentNode.parent;
		}
		
		if (currentNode == root) {
			return root;
		} else {
			return currentNode;
		}
	}
	
	/*
	 * No parent pointer, then get path from node1 to root, and path from node2 to root
	 * check if there is a node in path1 that is also in path2
	 */
	public Node findLowestCommonAncestor(Node root, Node node1, Node node2) {
		HashSet<Node> path1 = findNode(root, node1);
		
		HashSet<Node> path2 = findNode(root, node2);
		
		for (Node node : path1) {
			if (path2.contains(node)) {
				return node;
			}
		}
		
		throw new RuntimeException("Nothing found!");
	}
	
	public HashSet<Node> findNode(Node root, Node node) {
		if (root == null) {
			return null;
		}
		
		if (root == node) {
			HashSet<Node> path = new HashSet<BinaryTreeLCA.Node>();
			path.add(root);
			return path;
		} 
		
		HashSet<Node> leftPath = findNode(root.leftChild, node);
		if (leftPath != null) {
			leftPath.add(root);
			return leftPath;
		}
		
		HashSet<Node> rightPath = findNode(root.rightChild, node);
		if (rightPath != null) {
			rightPath.add(root);
			return rightPath;
		}
		
		return null;
	}

	public Node[] createTree() {
		Node root = new Node(1, null, null);
		Node node2 = new Node(2, null, null);
		Node node3 = new Node(3, null, null);
		Node node4 = new Node(4, null, null);
		Node node5 = new Node(5, null, null);
		Node node6 = new Node(6, null, null);
		Node node7 = new Node(7, null, null);
		
		root.leftChild = node2;
		root.rightChild = node3;
		
		node2.leftChild = node4;
		node2.rightChild = node5;
		
		node3.leftChild = node6;
		node3.rightChild = node7;
		
		node2.parent = root;
		node3.parent = root;
		
		node4.parent = node2;
		node5.parent = node2;
		
		node6.parent = node3;
		node7.parent = node3;
		
		return new Node[]{root, root, root};
	}
	
	static class Node {
		int value;
		Node leftChild;
		Node rightChild;
		Node parent;
		
		public Node(int value, Node leftChild, Node rightChild) {
			this(value, leftChild, rightChild, null);
		}
		
		public Node(int value, Node leftChild, Node rightChild, Node parent) {
			this.value = value;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
			this.parent = parent;
		}
	}
}
