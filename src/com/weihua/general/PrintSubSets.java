package com.weihua.general;
import java.util.ArrayList;
import java.util.List;

/*
 * print all subset. Using recursion
 */
public class PrintSubSets {

	public static void main(String[] args) {
		PrintSubSets test = new PrintSubSets();
		int[] input = null;
		List<List<Integer>> results = test.getSubsets(input);
		System.out.println(results);
		
		input = new int[]{1};
		results = test.getSubsets(input);
		System.out.println(results);
		
		input = new int[]{1, 2};
		results = test.getSubsets(input);
		System.out.println(results);
	}

	public List<List<Integer>> getSubsets(int[] input) {
		if (input == null) {
			return null;
		}
		return getSubsets(input, input.length);
	}
	
	public List<List<Integer>> getSubsets(int[] input, int n) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		if (n == 0) {
			List<Integer> subset = new ArrayList<Integer>();
			subsets.add(subset);
			return subsets;
		} else {
			List<List<Integer>> preSubsets = getSubsets(input, n-1);
			for (List<Integer> subset : preSubsets) {
				List<Integer> newSubset = new ArrayList<Integer>(subset);
				subsets.add(newSubset);
				subset.add(input[n-1]);
				List<Integer> newSubsetWithItem = new ArrayList<Integer>(subset);
				subsets.add(newSubsetWithItem);
			}
		}
		
		return subsets;
	}
}
