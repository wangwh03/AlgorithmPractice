package com.weihua.tree;

/**
 * Do we know if both nodes exist in BST?  If not, need to verify that they both exist first
 * Can we assume there is no repeated number in this BST?  Below algorithm does not work if there is repeated numbers
 * @author weihua
 *
 */
public class BSTLowestCommonAncestor {

	public static void main(String[] args) {
		BSTLowestCommonAncestor test = new BSTLowestCommonAncestor();
		Node root = test.createBST();
		Node node1 = new Node(6, null, null);
		Node node2 = new Node(5, null, null);
		System.out.println(test.getLCA(root, node1, node2).value);
	}
	
	public Node getLCA(Node root, Node node1, Node node2) {
		// check if two nodes exist in BST
		if (!existInBST(root, node1) || !existInBST(root, node2)) {
			return null;
		}
		
		if (node1.value < node2.value) {
			return _getLCA(root, node1, node2);
		} else {
			return _getLCA(root, node2, node1);
		}
	}
	
	// assume node1's value is smaller than or equals to node2's value
	private Node _getLCA(Node root, Node node1, Node node2) {
		if (root.value == node1.value || root.value == node2.value) {
			return root;
		}
		
		if (node1.value < root.value && root.value < node2.value) {
			return root;
		} else if (node1.value > root.value) {
			return _getLCA(root.rightChild, node1, node2);
		} else {
			return _getLCA(root.leftChild, node1, node2);
		}
	}
	
	private boolean existInBST(Node root, Node node) {
		if (root == null || node == null) {
			return false;
		}
			
		if (root.value == node.value) {
			return true;
		}
		
		boolean existInLeft = existInBST(root.leftChild, node);
		if (existInLeft) {
			return true;
		}
		
		boolean existInRight = existInBST(root.rightChild, node);
		return existInRight;
	}
	
	public Node createBST() {
		Node root = new Node(4, null, null);
		Node node1 = new Node(1, null, null);
		Node node2 = new Node(2, null, null);
		Node node3 = new Node(3, null, null);
		Node node7 = new Node(7, null, null);
		Node node5 = new Node(5, null, null);
		Node node6 = new Node(6, null, null);
		
		root.leftChild = node2;
		root.rightChild = node6;
		node2.leftChild = node1;
		node2.rightChild = node3;
		node6.leftChild = node5;
		node6.rightChild = node7;

		return root;
	}
	
	public static class Node {
		int value;
		Node leftChild;
		Node rightChild;
		public Node(int value, Node leftChild, Node rightChild) {
			this.value = value;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}
	}

}
