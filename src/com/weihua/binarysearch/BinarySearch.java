package com.weihua.binarysearch;

/*
 * Practice of binary search
 * If there are duplicates, return the first index of this number(slightly modify binary search)
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch test = new BinarySearch();
        int[] input = new int[]{1, 3, 5, 7, 9, 10, 11};
//        System.out.println(test.search(input, 5));
//        System.out.println(test.search(input, 1));
//        System.out.println(test.search(input, 11));
//        System.out.println(test.search(input, 8));
        
        input = new int[]{1, 5, 5, 5, 5, 10, 11};
        System.out.println(test.searchFirstIndex(input, 5));
        System.out.println(test.searchFirstIndex(input, 11));
    }
    
    public int search(int[] input, int desiredNumber) {
        return search(input, desiredNumber, 0, input.length-1);
    }
    
    private int search(int[] input, int desiredNumber, int left, int right) {
        if (left > right) {
            throw new IllegalArgumentException("number not found1");
        }
        int middle = (left + right) / 2;
        if (input[middle] == desiredNumber) {
            return middle;
        } else if (input[middle] < desiredNumber) {
            return search(input, desiredNumber, middle + 1, right);
        } else {
            return search(input, desiredNumber, left, middle - 1);
        }
    }
    
    public int searchFirstIndex(int[] input, int desiredNumber) {
        return searchFirstIndex(input, desiredNumber, 0, input.length-1);
    }
    
    private int searchFirstIndex(int[] input, int desiredNumber, int left, int right) {
        if (left == right) {
            if (input[left] != desiredNumber) {
                throw new IllegalArgumentException("number not in input!");
            } else if (input[left] == desiredNumber) {
                return left;
            }
        }
        int middle = (left + right) / 2;
        if (input[middle] < desiredNumber) {
            return searchFirstIndex(input, desiredNumber, middle + 1, right);
        } else {
            return searchFirstIndex(input, desiredNumber, left, middle); // include middle if equals
        }
    }
}
