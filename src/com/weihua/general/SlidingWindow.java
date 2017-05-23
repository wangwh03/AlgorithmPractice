package com.weihua.general;

/*
 * given an array of integers, and k, find the min number inside window k
 * This is the simplest solution that calculates each window
 */
public class SlidingWindow {
    private int[] numbers = new int[]{ 1, 2, 3, 3, 10, 9, 6, 7};
    private int k = 3;

    public static void main(String[] args) {
        SlidingWindow test = new SlidingWindow();
        int[] results = test.getMaxNumbers();
        test.print(results);
    }

    public void print(int[] inputs){
        for (int i = 0; i < inputs.length; i++) {
            System.out.println(inputs[i]);
        }
    }
    
    public int[] getMaxNumbers() {
        int[] maxNumbers = new int[numbers.length - k + 1];
        
        for (int i = 0; i < maxNumbers.length; i++) {
            maxNumbers[i] = getMaxNumber(i);
        }
        
        return maxNumbers;
    }
    
    private int getMaxNumber(int index) {
        int max = numbers[index];
        for (int i = index + 1; i < index + k; i++) {
            max = Math.max(max, numbers[i]);
        }
        
        return max;
    }
}
