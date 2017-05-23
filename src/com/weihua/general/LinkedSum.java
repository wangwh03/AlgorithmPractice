package com.weihua.general;

/*
 * calculate sum of two intgers, integers are stored as lists
 */
public class LinkedSum {

	int carrier = 0;
	Node result;
	Node resultRoot;
	
	public static void main(String[] args) {
		LinkedSum test = new LinkedSum();
		Node node1 = test.create();
		Node node2 = test.create2();
		Node result = test.sum(node1, node2);
		test.printLinkedList(result);
	}
	
	public Node sum(Node node1, Node node2) {
		while(node1 != null && node2 != null) {
			int sum = node1.value + node2.value + carrier;
			carrier = sum / 10;
			sum = sum % 10;
			Node current = new Node(sum);
			if (result == null) {
				result = current;
				resultRoot = result;
			} else {
				result.next = current;
				result = result.next;
			}
			node1 = node1.next;
			node2 = node2.next;
		}
		
		while (node1 != null) {
			add(node1);
			node1 = node1.next;
		}
		
		while (node2 != null) {
			add(node2);
			node2 = node2.next;
		}
		
		if (carrier != 0) {
			result.next = new Node(carrier);
		}
		return resultRoot;
	}
	
	private void add(Node node) {
		int sum = node.value + carrier;
		carrier = sum / 10;
		sum = sum % 10;
		Node current = new Node(sum);
		if (result == null) {
			result = current;
			resultRoot = result;
		} else {
			result.next = current;
			result = result.next;
		}
	}
	
	private void printLinkedList(Node root) {
		while (root != null) {
			System.out.print(root.value + " ");
			root = root.next;
		}
		System.out.println();
	}

	public Node create() {
		Node root = new Node(2);
		Node node2 = new Node(4);
		Node node3 = new Node(6);
		Node node4 = new Node(8);
		root.next = node2;
		node2.next = node3;
		node3.next = node4;

		return root;
	}

	public Node create2() {
		Node root = new Node(2);
		Node node2 = new Node(4);
		Node node3 = new Node(6);
		root.next = node2;
		node2.next = node3;

		return root;
	}
	
	public static class Node {
		int value;
		Node next;

		public Node(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value + "";
		}
	}
}
