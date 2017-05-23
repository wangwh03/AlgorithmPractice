package com.weihua.general;

public class MySorter2 {

    public static void main(String[] args) {
        MySorter2 test = new MySorter2();
        int[] input = new int[] {1, 2, 3, 4, 100, 7, 6, 10};
        test.bubbleSort(input);
        test.print(input);
        test.mergeSort(input);
        test.print(input);
    }
        
    public void bubbleSort(int[] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j] > input[j+1]) {
                    swap(input, j, j+1);
                }
            }
        }
    }
    
    public int[] mergeSort(int[] input) {
        int[] sortedResult = mergeSort(input, 0, input.length);
        return sortedResult;
    }
    
    private int[] mergeSort(int[] input, int l, int r) {
        if (l == r - 1) {
            return new int[]{input[l]};
        }  
        
        int m = (l + r) / 2;
        int[] left = mergeSort(input, l, m);
        int[] right = mergeSort(input, m, r);
        int[] mergedResult = merge(left, right);
        return mergedResult;
    }
    
    private int[] merge(int[] left, int[] right) {
        int[] mergedResult = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int i = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                mergedResult[i] = left[leftIndex];
                leftIndex++;
            } else {
                mergedResult[i] = right[rightIndex];
                rightIndex++;
            }
            i++;
        }
        if (leftIndex == left.length -1 && rightIndex < right.length - 1) {
            for (; i < left.length + right.length - 1; i++) {
                mergedResult[i] = right[rightIndex];
                rightIndex++;
            }
        }
        
        if (leftIndex < left.length -1 && rightIndex == right.length - 1) {
            for (; i < left.length + right.length - 1; i++) {
                mergedResult[i] = left[leftIndex];
                leftIndex++;
            }
        }
        return mergedResult;
    }
    
    private void swap(int[] input, int i, int j) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }
    
    private void print(int[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println();
    }
}
