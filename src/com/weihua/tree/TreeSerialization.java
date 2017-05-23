package com.weihua.tree;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;


/*
 * not working!
 */
public class TreeSerialization {

	public static void main(String[] args) throws IOException {
		TreeSerialization test = new TreeSerialization();
		Node root = test.createTree();
		test.serialize(root);
		
		Node newRoot = test.deserialize();
		test.print(newRoot);
	}

	public void serialize(Node root) throws IOException {
		File file = new File("/Users/weihua/Desktop/tree.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fileWriter);
		
		writeBT(bw, root);
		bw.close();
	}
	
	private void writeBT(BufferedWriter bw, Node node) throws IOException {
		if (node == null) {
			bw.write("N\n");
			return;
		}

		bw.write(node.value + "\n");
		writeBT(bw, node.left);
		writeBT(bw, node.right);
	}
	
	
	public Node deserialize() throws IOException {
		FileReader fileReader = new FileReader("/Users/weihua/Desktop/tree.txt");
		BufferedReader bf = new BufferedReader(fileReader);
		
		Node root = new Node(100);
		readBT(root, bf);
		bf.close();
		
		return root;
	}
	
	private void readBT(Node node, BufferedReader bf) throws IOException {
		String line = bf.readLine();
		int number;
		if (line != null && !line.equals("N")) {
			number = Integer.parseInt(line);
			if (node == null) {
				node = new Node(number);
			} else {
				node.value = number;
			}
			readBT(node.left, bf);
			readBT(node.right, bf);
		}
	}
	
	public static class Node {
		private Node left;
		private Node right;
		private int value;
		
		public Node(int number) {
			this.value = number;
		}
		
		public void setLeft(Node left) {
			this.left = left;
		}
		
		public void setRight(Node right) {
			this.right = right;
		}
		
		public Node getLeft() {
			return left;
		}
		
		public Node getRight() {
			return right;
		}
		
		public int getValue() {
			return value;
		}
	}
	
	private void print(Node root) {
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
				System.out.print(current.value + " ");
				if (current.left != null) {
					queue.offer(current.left);
				}
				if (current.right != null) {
					queue.offer(current.right);
				}
			}
		}
	}
	
	public Node createTree() {
		Node root = new Node(1);
		
		Node node1 = new Node(2);
		root.left = node1;
		Node node2 = new Node(3);
		root.right = node2;
		
		Node node11 = new Node(4);
		node1.left = node11;
		return root;
	}
}
