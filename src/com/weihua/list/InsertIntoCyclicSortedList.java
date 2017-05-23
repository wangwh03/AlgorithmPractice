package com.weihua.list;

/*
 * insert a number into a cyclic sorted list
 * draw in a piece of paper to find out all cases.  
 * 1. new value between current node value and next node value: insert
 * 2. current node larger than next node: next node is the head.  
 * 	  If new node larger than current node, insert after tail
 *    If new node smaller than next node, insert before head
 *    either case, insert between current and next
 *    
 * pay attention to the duplicate number cases
 */
public class InsertIntoCyclicSortedList {

	/**
	 * pay special attention to duplicate cases: 1 3 3 5 6, insert 4, given the first 3
	 */
	public static void main(String[] args) {
		InsertIntoCyclicSortedList test = new InsertIntoCyclicSortedList();
		Node node = test.createCyclicNode();
		Node newNode = test.new Node(2, null);
		test.insert(node, newNode);
		test.printCyclicList(node);
	}

	public void insert(Node node, Node newNode) {
		if (node == null) {
			newNode.next = newNode;
			node = newNode;
			return;
		}
		
		Node currentNode = node;
		Node nextNode = currentNode.next;
		if (currentNode == nextNode) {
			currentNode.next = newNode;
			newNode.next = currentNode;
		}
		
		do {
			if (currentNode.value <= newNode.value && newNode.value <= nextNode.value
					|| (currentNode.value > nextNode.value 
							&& (newNode.value <= nextNode.value || newNode.value >= currentNode.value))) {
				currentNode.next = newNode;
				newNode.next = nextNode;
				return;
			} 
			currentNode = nextNode;
			nextNode = nextNode.next;
		} while (node != currentNode);
		
		// pay special attention to here: if 3 3 3 and insert 1
		newNode.next = currentNode.next;
		currentNode.next = newNode;
	}
		
	public void printCyclicList(Node node) {
		Node currentNode = node;
		do {
			System.out.println(currentNode.value);
			currentNode = currentNode.next;
		} while (node != currentNode);
	}
	
	public Node createCyclicNode() {
		Node node5 = new Node(1, null);
		Node node4 = new Node(1, node5);
		Node node3 = new Node(1, node4);
		Node node2 = new Node(1, node3);
		Node node1 = new Node(1, node2);
		node5.next = node1;
		
		return node2;
	}
	
	public class Node {
		int value;
		Node next;
		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
	}
}


