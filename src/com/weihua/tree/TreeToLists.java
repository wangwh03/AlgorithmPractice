package com.weihua.tree;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*
 * convert a binary tree to a list of list
 * each level of tree is a list
 * use a queue.  Similar to print tree in level
 */
public class TreeToLists {

	public static void main(String[] args) {
		TreeToLists test = new TreeToLists();
		Node root = test.createTree();
		test.createLists(root);
	}

	public List<List<Node>> createLists(Node root) {
		if (root == null) {
			return null;
		}
		
		List<List<Node>> results = new LinkedList<List<Node>>();
		Queue<Node> queue = new LinkedList<TreeToLists.Node>();
		queue.offer(root);
		Node pivot = new Node(Integer.MAX_VALUE);
		queue.offer(pivot);
		List<Node> firstlist = new LinkedList<TreeToLists.Node>();
		results.add(firstlist);
		int listIndex = 0;
		while(queue.size() != 1) {
			Node current = queue.remove();
			if (current.equals(pivot)) {
				List<Node> newList = new LinkedList<TreeToLists.Node>();
				results.add(newList);
				queue.add(pivot);
				listIndex++;
			} else {
				results.get(listIndex).add(current);
				if (current.left != null) {
					queue.add(current.left);
				}
				if (current.right != null) {
					queue.add(current.right);
				}
			}
		}
		
		return results;
	}
	
	public Node createTree() {
		Node root = new Node(1);
		Node left = new Node(2);
		Node right = new Node(3);
		root.left = left;
		root.right = right;
		return root;
	}
	public static class Node {
		int value;
		Node left;
		Node right;
		
		public Node(int value) {
			this.value = value;
		}
	}
}
