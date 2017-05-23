package com.weihua.general;

import java.util.ArrayList;
import java.util.List;

public final class FactoryUtils {
    public static Graph createGraph() {
        List<Integer> firstNode = new ArrayList<Integer>();
        firstNode.add(1);
        firstNode.add(2);
        firstNode.add(5);
        
        List<Integer> secondNode = new ArrayList<Integer>();
        secondNode.add(2);
        secondNode.add(1);
        secondNode.add(5);
        secondNode.add(3);
        secondNode.add(4);
        
        List<Integer> thirdNode = new ArrayList<Integer>();
        thirdNode.add(3);
        thirdNode.add(2);
        thirdNode.add(4);

        List<Integer> forthNode = new ArrayList<Integer>();
        forthNode.add(4);
        forthNode.add(2);
        forthNode.add(5);
        forthNode.add(3);

        List<Integer> fifthNode = new ArrayList<Integer>();
        fifthNode.add(5);
        fifthNode.add(4);
        fifthNode.add(1);
        fifthNode.add(2);
        
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        graph.add(firstNode);
        graph.add(secondNode);
        graph.add(thirdNode);
        graph.add(forthNode);
        graph.add(fifthNode);
        return new Graph(graph);
    }
    
    public static class Graph {
        List<List<Integer>> graph;
        
        public Graph(List<List<Integer>> graph) {
            this.graph = graph;
        }
    }
}
