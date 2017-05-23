package com.weihua.general;

import java.util.HashSet;

/*
 * back-tracking
 * find an empty spot that needs a number, try the first number that is valid, then converted into a sub-problem.
 * If this sub-problem does not have a solution, then undo the number, try the second valid number, and keep trying
 * If no valid number, then this solution does not work out.
 */
public class SudokuSolver {

    public static void main(String[] args) {
        SudokuSolver test = new SudokuSolver();
        Integer[][] numbers = {
                {5, null, 4, 3, null, null, null, 6, null},
                {1, null, 3, null, 5, null, 2, 4, null},
                {null, null, null, null, null, 4, 5, null, null},
                {null, 1, null, null, null, 8, null, 7, null},
                {8, 7, 9, null, null, null, 3, 5, 2},
                {null, 4, null, 7, null, null, null, 1, null},
                {null, null, 2, 8, null, null, null, null, null},
                {null, 3, 1, null, 7, null, 8, null, 4},
                {null, 5, null, null, null, 3, 1, null, 7},

        };
        Graph graph = new Graph(numbers);
        if (test.solve(graph)) {
            test.graphPrint(graph);
        } else {
            System.out.println("no solution");
        }
    }

    public boolean solve(Graph graph) {
        int[] nextEmptyPlace = getNextEmptyPlace(graph);
        // If there is no empty spot, then solved
        if (nextEmptyPlace[0] == -1) {
            return true;
        }

        for (int i = 1; i <= 9; i++) {
        	// try the valid numbers for this empty spot
            if (isValid(graph, nextEmptyPlace[0], nextEmptyPlace[1], i)) {
                graph.setNumber(nextEmptyPlace[0], nextEmptyPlace[1], i);
                // converted into a sub-problem
                if (solve(graph)) {
                    return true;
                }
                // undo the number set since did not work out.
                graph.setNumber(nextEmptyPlace[0], nextEmptyPlace[1], null);
            }
        }

        return false;
    }

    private int[] getNextEmptyPlace(Graph graph) {
        Integer[][] numbers = graph.getNumbers();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[0].length; j++) {
                if (numbers[i][j] == null) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private boolean isValid(Graph graph, int newRow, int newCol, int number) {
        graph.setNumber(newRow, newCol, number);
        // validate row
        HashSet<Integer> set = new HashSet<Integer>();
        for (int col = 0; col < 9; col++) {
            if (graph.getNumbers()[newRow][col] != null) {
                if (set.contains(graph.getNumbers()[newRow][col])) {
                    graph.setNumber(newRow, newCol, null);
                    return false;
                }
                set.add(graph.getNumbers()[newRow][col]);
            }
        }

        // validate col
        set.clear();
        for (int row = 0; row < 9; row++) {
            if (graph.getNumbers()[row][newCol] != null) {
                if (set.contains(graph.getNumbers()[row][newCol])) {
                    graph.setNumber(newRow, newCol, null);
                    return false;
                }
                set.add(graph.getNumbers()[row][newCol]);
            }
        }

        // validate small square
        set.clear();
        int rowStarter = newRow - newRow % 3;
        int colStarter = newCol - newCol % 3;
        for (int row = rowStarter; row < rowStarter + 3; row++) {
            for (int col = colStarter; col < colStarter + 3; col++) {
                if (graph.getNumbers()[row][col] != null) {
                    if (set.contains(graph.getNumbers()[row][col])) {
                        graph.setNumber(newRow, newCol, null);
                        return false;
                    }
                    set.add(graph.getNumbers()[row][col]);
                }
            }
        }

        return true;
    }

    public void graphPrint(Graph graph) {
        Integer[][] numbers = graph.getNumbers();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[0].length; j++) {
                System.out.print(numbers[i][j]);
            }
            System.out.println();
        }
    }

    public static class Graph {
        private Integer[][] numbers;

        public Graph(Integer[][] graph) {
            this.numbers = graph;
        }

        public void setNumber(int row, int col, Integer number) {
            numbers[row][col] = number;
        }

        public Integer[][] getNumbers() {
            return numbers;
        }
    }
}
