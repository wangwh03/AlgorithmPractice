package com.weihua.general;

/*
 * given a matrix, each row sorted, each column sorted, find a given number
 * start from the upper right cell, compare, if this number is smaller than given number, then the whole row is smaller,
 * row++; otherwise, the whole column is too large, col--
 * 
 * Another way to do this is similar to binary search, but complicated.  Basically search the diagonal and find the 
 * adjecent values of the given number.  For all upper left part of matrix, too small, for all lower right part of matrix,
 * too large.  Search the two area of upper right and bottom left to find the given number
 */
public class FindMinMatrix {

    public static void main(String[] args) {
        FindMinMatrix test = new FindMinMatrix();
        int[][] input = new int[][]{
                {1, 3, 5, 7},
                {2, 4, 6, 8},
                {9, 10, 11, 12}};
        
        int number = 7;
        int[] result = test.findMin(input, number);
        System.out.println(result[0] + " " + result[1]);
    }
    
    public int[] findMin(int[][] input, int number) {
        int i = 0;
        int j = input[0].length - 1;
        while (i < input.length && j >=0 && input[i][j] != number) {
            if (input[i][j] > number) {
                j--;
            } else {
                i++;
            }
        }
        
        if (i == input.length || j < 0) {
            throw new IllegalArgumentException("nothing find");
        } else {
            return new int[]{i, j};
        }
    }
}
