package com.weihua.tree;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * recursivly print all paths of a binary tree
 */
public class PrintAllPath {

    public static void main(String[] args) {
        PrintAllPath test = new PrintAllPath();
        Node root = TreeUtils.createTree();
        Collection<List<Node>> paths = test.getAllPaths(root);
        System.out.println(paths);
        test.printSum(paths, 8);
        test.printFlexSum(paths, 6);
    }
    
    public Collection<List<Node>> getAllPaths(Node root) {
        if (root == null) {
            return null;
        }
        HashMap<Node, List<Node>> paths = new HashMap<Node, List<Node>>();
        List<Node> rootPath = new LinkedList<Node>();
        rootPath.add(root);
        paths.put(root, rootPath);
        
        getAllPaths(root, paths);
        return paths.values();
    }
    
    private void getAllPaths(Node node, HashMap<Node, List<Node>> paths) {
        List<Node> currentPathEndingNode = paths.get(node);
        if (node.getLeft() == null && node.getRight() == null) {
            return;
        }
        
        paths.remove(node);
        if (node.getLeft() != null) {
            List<Node> newPath = new LinkedList<Node>(currentPathEndingNode);
            newPath.add(node.getLeft());
            paths.put(node.getLeft(), newPath);
            getAllPaths(node.getLeft(), paths);
        }
        if (node.getRight() != null) {
            List<Node> newPath = new LinkedList<Node>(currentPathEndingNode);
            newPath.add(node.getRight());
            paths.put(node.getRight(), newPath);
            getAllPaths(node.getRight(), paths);
        }
    }
    
    public void printSum(Collection<List<Node>> paths, int sum) {
        for (List<Node> path : paths) {
            int currentSum = 0;
            int index = 0;
            for (Node node : path) {
                currentSum += node.getValue();
                index++;
                if (sum == currentSum) {
                    System.out.println((path.subList(0, index)));
                }
            }
        }
    }

    
    public void printFlexSum(Collection<List<Node>> paths, int sum) {
        for (List<Node> path : paths) {
            validAndPrint(path, sum);
        }
    }
    
    private void validAndPrint(List<Node> path, int sum) {
        for (int i = 0; i < path.size(); i++) {
            int currentSum = 0;
            for (int j = i; j < path.size(); j++) {
                currentSum += path.get(j).getValue();
                if (sum == currentSum) {
                    System.out.println((path.subList(i, j+1)));
                }
            }
        }
    }
}
