package com.weihua.list;
import java.util.HashSet;
import java.util.Set;


public class LinkedListPractice {

	public static void main(String[] args) {
		LinkedListPractice test = new LinkedListPractice();
		Node root = test.create();
		test.printLinkedList(root);
		//		root = test.delete(root, 1);
		//		root = test.delete(root, 2);
		//		root = test.delete(root, 4);
		//		root = test.delete(root, 4);
		//
		//		test.printLinkedList(root);
		//		
		//		test.removeDup(root);
		//		test.printLinkedList(root);
		test.partition(root, 30);
		test.printLinkedList(root);
	}

	public Node partition(Node root, int input) {
		if (root == null) {
			return null;
		}

		Node leftList = null;
		Node rightList = null;
		Node current = root;
		Node next = null;
		Node rightListRoot = null;
		try {
			while (current != null) {
				next = current.next;
				if (current.value < input) {
					if (leftList == null) {
						leftList = current;
						root = leftList;
					} else {
						leftList.next = current;
						leftList = leftList.next;
					}
				} else {
					if (rightList == null) {
						rightList = current;
						rightListRoot = rightList;
					} else {
						rightList.next = current;
						rightList = rightList.next;
					}
				}
				current = next;
			}
			if (leftList != null) {
				leftList.next = rightListRoot;
			} else {
				root = rightListRoot;
			}
			if (rightList != null) {
				rightList.next = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Node tmp = root;
		while (tmp != null) {
			System.out.print(tmp.value + " ");
			tmp = tmp.next;
		}
		System.out.println();
		return root;
	}

	public void removeDup(Node root) {
		// or a set of Node instead of Integer
		Set<Integer> appearedValues = new HashSet<Integer>();
		Node current = root;
		Node pre = null;
		while (current != null) {
			if (appearedValues.contains(current.value)) {
				pre.next = current.next;
			} else {
				appearedValues.add(current.value);
			}
			pre = current;
			current = current.next;
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
		Node root = new Node(100);
		Node node2 = new Node(20);
		Node node3 = new Node(80);
		Node node4 = new Node(0);
		root.next = node2;
		node2.next = node3;
		node3.next = node4;

		return root;
	}

	public Node delete(Node root, int valueToDelete) {
		if (root == null) {
			throw new IllegalArgumentException("empty list");
		}

		Node pre = null;
		Node current = root;
		while(current != null && current.value != valueToDelete) {
			pre = current;
			current = current.next;
		}

		if (pre == null) {
			return root.next;
		} 

		if (current == null) {
			throw new IllegalArgumentException("value not in list");
		} else {
			pre.next = current.next;
		}

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
