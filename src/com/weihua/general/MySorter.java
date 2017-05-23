package com.weihua.general;

public class MySorter {

	public static void main(String[] args) {
		MySorter test = new MySorter();
		int[] input = new int[] {1, 2, 3, 9, 5, 7, 6};
		test.insertSort(input);
		test.print(input);
		
		input = null;
		test.insertSort(input);
		test.print(input);
		
		input = new int[]{};
		test.insertSort(input);
		test.print(input);
		
		input = new int[]{1};
		test.insertSort(input);
		test.print(input);
		
		input = new int[] {1, 2, 3, 9, 5, 7, 6};
		test.quickSort(input);
		test.print(input);
		
		input = null;
		test.quickSort(input);
		test.print(input);
		
		input = new int[]{};
		test.quickSort(input);
		test.print(input);
		
		input = new int[]{1};
		test.quickSort(input);
		test.print(input);
		
		input = new int[] {2, 5, 3, 0, 2, 3, 0,3};
		int[] result = test.countSort(input, 10);
		test.print(result);
	}

	public void insertSort(int[] input) {
		if (input == null || input.length < 2) {
			return;
		}
		
		for (int i = 2; i < input.length; i++) {
			int key = input[i];
			int j = i - 1;
			while (j >= 0 && input[j] > key) {
				input[j+1] = input[j];
				j--;
			}
			input[j+1] = key;
		}
	}
	
	public int[] countSort(int[] input, int range) {
		if (input == null || input.length < 2) {
			return input;
		}
		int[] counter = new int[range+1];
		for (int i = 0; i < input.length; i++) {
			counter[input[i]] = counter[input[i]] + 1;
		}
		
		for (int i = 1; i <= range; i++) {
			counter[i] = counter[i] + counter[i-1];
		}
		
		int[] result = new int[input.length];
		for (int i = input.length-1; i >= 0; i--) {
			result[counter[input[i]]-1] = input[i];
			counter[input[i]] = counter[input[i]] - 1;
		}
		
		return result;
	}
	
	public void quickSort(int[] input) {
		if (input == null || input.length <= 1) {
			return;
		}
		quickSort(input, 0, input.length);
	}
	
	private void quickSort(int[] input, int l, int r) {
		if (l >= r) {
			return;
		}
		int m = partition(input, l, r);
		quickSort(input, l, m);
		quickSort(input, m+1, r);
	}
	
	private int partition(int[] input, int l, int r) {
		int pivot = input[l];
		int leftIndex = l;
		for (int i = l+1; i < r; i++) {
			if (input[i] < pivot) {
				leftIndex++;
				swap(input, leftIndex, i);
			}
		}
		swap(input, l, leftIndex);
		return leftIndex;
	}
	
	private void swap(int[] input, int i, int j) {
		int tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;
	}
	
	public void print(int[] input) {
		if (input == null) {
			return;
		}
		
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
		System.out.println();
	}

}
