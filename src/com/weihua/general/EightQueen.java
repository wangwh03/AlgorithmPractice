package com.weihua.general;

import java.util.ArrayList;

public class EightQueen {

    public static void main(String[] args) {
        EightQueen test = new EightQueen();
        test.getSolution(4);
    }
    
    /*
     * N is the number of queen
     */
    public void getSolution(int n) {
        ArrayList<Integer[]> results = new ArrayList<Integer[]>();
        getQueuePositions(n, results, 0, new Integer[n]);
        System.out.println(results.size());
    }

    /*
     * try to place a queen at a row each time.  once placed the last queen in last row, we find a valid solution
     * For a particular row, check all columns to find a valid position. Then the problem is converted to subproblem
     */
    private void getQueuePositions(int n, 
            ArrayList<Integer[]> results, int row, Integer[] columns) {
        if (row == n) {
            results.add(columns.clone());
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, columns)) {
                columns[row] = col;
                getQueuePositions(n, results, row+1, columns);
            }
        }
    }
    
    private boolean isValid(int row1, int column1, Integer[] columns) {
        for (int row2 = 0; row2 < row1; row2++) {
            int columns2 = columns[row2];
            if (columns2 == column1) {
                return false;
            }
            
            int rowDistance = row1 - row2;
            int columnDistance = Math.abs(columns2 - column1);
            if (rowDistance == columnDistance) {
                return false;
            }
        }
        
        return true;
    }
}
