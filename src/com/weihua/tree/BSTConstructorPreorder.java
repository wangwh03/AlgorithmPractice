package com.weihua.tree;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * construct a binary search tree from pre-order
 * first one is root, all numbers that are smaller than root is in left subtree, recursively create left-subtree
 * same as right subtree
 */
public class BSTConstructorPreorder {
    public static void main(String[] args) throws IOException {
        int[] tree = {8, 3, 1, 6, 4, 7, 10, 14, 13};
        Node root = constructFromPreorder(tree);
        printBST(root);
    }
    
    private static Node constructFromPreorder(int[] tree) {
        if (tree == null || tree.length == 0) {
            return null;
        }
        Node root = new Node(tree[0]);
        if (tree.length ==1 ) {
            return root;
        }
        Node leftRoot = constructFromPreorder(getLeft(tree, root));
        root.setLeft(leftRoot);
        Node rightRoot = constructFromPreorder(getRight(tree, root));
        root.setRight(rightRoot);
        
        return root;
    } 
    
    private static int[] getLeft(int[] tree, Node root) {
        int i = 0;
        while(i < tree.length && tree[i] <= root.getValue()) {
            i++;
        }
        if(i<1) {
            return null;
        }
        return Arrays.copyOfRange(tree, 1, i);
    }
    
    private static int[] getRight(int[] tree, Node root) {
        int i = 0;
        while(i < tree.length && tree[i] <= root.getValue()) {
            i++;
        }
        if (i >= tree.length) {
            return null;
        }
        return Arrays.copyOfRange(tree, i, tree.length);
    }
    
    private static void printBST(Node root) {
        Queue<Node> tree = new LinkedList<Node>();
        tree.offer(root);
        
        Node pivot = new Node(Integer.MAX_VALUE);
        tree.offer(pivot);
        while(!tree.isEmpty() && tree.size() != 1) {
            Node current = tree.remove();
            if (current.getValue() == Integer.MAX_VALUE) {
                tree.offer(pivot);
                System.out.println();
                continue;
            }
            System.out.print(current.getValue() + "\t");
            if (current.getLeft() != null) {
                tree.offer(current.getLeft());
            }
            if (current.getRight() != null) {
                tree.offer(current.getRight());
            }
        }
    }
    
    private static class Node {
        int value;
        Node left;
        Node right;
        
        Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }        
    }
}


