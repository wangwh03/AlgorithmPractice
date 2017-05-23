package com.weihua.tree;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Given pre-order and in-order travesal, constructor the binary tree, note not a binary search tree
 * Basic idea: start from the pre-order, the first node is root.  
 * All nodes that is in left side of root in pre-order is root's left-subtree, recursively constructor its left subtree
 * do same thing to construct right subtree
 */
public class ConstructBinaryTree {

	public static void main(String[] args) {
		ConstructBinaryTree test = new ConstructBinaryTree();
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);

		List<Node> preOrder = new LinkedList<ConstructBinaryTree.Node>();
		preOrder.add(node1);
		preOrder.add(node2);
		preOrder.add(node4);
		preOrder.add(node5);
		preOrder.add(node3);
		preOrder.add(node6);
		preOrder.add(node7);

		List<Node> inOrder = new LinkedList<ConstructBinaryTree.Node>();
		inOrder.add(node4);
		inOrder.add(node2);
		inOrder.add(node5);
		inOrder.add(node1);
		inOrder.add(node6);
		inOrder.add(node3);
		inOrder.add(node7);
		
		Node root = test.constructBinaryTree(preOrder, inOrder);
		test.printTreeInLevel(root);
	}

	public Node constructBinaryTree(List<Node> preOrder, List<Node> inOrder) {
		if (preOrder == null || preOrder.size() == 0) {
			return null;
		}
		
		Node root = preOrder.get(0);
		
		int i = 0;
		while (!inOrder.get(i).equals(root)) {
			i++;
		}
		
		Node leftChild = constructBinaryTree(preOrder.subList(1, i+1), inOrder.subList(0, i));
		Node rightChild = constructBinaryTree(preOrder.subList(i+1, preOrder.size()), inOrder.subList(i+1, preOrder.size()));
		
		root.leftChild = leftChild;
		root.rightChild = rightChild;
		
		return root;
	}
	
	public void printTreeInLevel(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		Node pivot = new Node(Integer.MAX_VALUE);
		queue.offer(pivot);
		while (queue.size() != 1) {
			Node currentNode = queue.poll();
			if (currentNode.equals(pivot)) {
				queue.offer(pivot);
				System.out.println();
			} else {
				System.out.print(currentNode.value + "\t");
				queue.offer(currentNode.leftChild);
				queue.offer(currentNode.rightChild);
			}
		}
	}
	
	public static class Node {
		int value;
		Node leftChild;
		Node rightChild;
		
		public Node(int value) {
			this(value, null, null);
		}
		
		public Node(int value, Node leftChild, Node rightChild) {
			this.value = value;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}
	}
}
