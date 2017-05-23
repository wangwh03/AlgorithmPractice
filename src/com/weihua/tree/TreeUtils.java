package com.weihua.tree;

import java.util.LinkedList;
import java.util.Queue;

public final class TreeUtils {

    public static Node createTree() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        
        node1.setLeft(node2);
        node1.setRight(node3);
        
        node2.setLeft(node4);
        node2.setRight(node5);
        
        node3.setLeft(node6);
        node3.setRight(node7);
        
        return node1;
    }
    
    public static Node createSubTree() {
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        
        node2.setLeft(node4);
        node2.setRight(node5);
        
        return node2;
    }
    
    public static Node createAnotherTree() {
        Node node10 = new Node(10);
        return node10;
    }
    
	public static void print(Node root) {
		Node pivot = new Node(Integer.MAX_VALUE);
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		queue.offer(pivot);
		while(queue.size() != 1) {
			Node current = queue.remove();
			if (current.equals(pivot)) {
				queue.offer(pivot);
				System.out.println();
			} else {
				System.out.print(current.getValue() + " ");
				if (current.getLeft() != null) {
					queue.offer(current.getLeft());
				}
				if (current.getRight() != null) {
					queue.offer(current.getRight());
				}
			}
		}
	}
}
