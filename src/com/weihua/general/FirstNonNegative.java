package com.weihua.general;

/*
 * Find the first non negative number in an array
 * Suppose the array size is n, then the first non negative number must be between 0 to n,
 * since n size array contains n non-negative integers at most
 * The first algorithm uses extra linear memory,
 * second is in place, but changes the original array
 */
public class FirstNonNegative {

	public static void main(String[] args) {
		FirstNonNegative test = new FirstNonNegative();
		int[] input = new int[]{1};
		System.out.println(test.getFirstNonNegative(input));
		System.out.println(test.getFirstNonNegativeInPlace(input));
		
		input = new int[]{0};
		System.out.println(test.getFirstNonNegative(input));
		System.out.println(test.getFirstNonNegativeInPlace(input));
		
		input = new int[]{0, 1, 2, 10, 10};
		System.out.println(test.getFirstNonNegative(input));
		System.out.println(test.getFirstNonNegativeInPlace(input));
	}
	
	public int getFirstNonNegative(int[] input) {
		if (input == null) {
			throw new IllegalArgumentException("Input cannot be null!");
		}
		
		int[] counter = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			if (input[i] < counter.length) {
				counter[input[i]] = 1;
			}
		}
		
		for (int i = 0; i < counter.length; i++) {
			if (counter[i] == 0) {
				return i;
			}
		}
		
		return input.length;
	}
	
	public int getFirstNonNegativeInPlace(int[] input) {
		if (input == null) {
			throw new IllegalArgumentException("Input cannot be null!");
		}
		
		for (int i = 0; i < input.length; i++) {
			if (input[i] != i && input[i] < input.length) {
				// swap input[i] and input[input[i]]
				swap(input, i, input[i]);
			}
		}
		
		for (int i = 0; i < input.length; i++) {
			if (input[i] != i) {
				return i;
			}
		}
		
		return input.length;
	}
	
	private void swap(int[] input, int i, int j) {
		int tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;
	}
}
