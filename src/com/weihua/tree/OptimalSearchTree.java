package com.weihua.tree;

/*
 * standford online class
 */
public class OptimalSearchTree {
	double[] frequencies = {.05, .4, .08, .04, .1, .1, .23};
	double[][] results = new double[frequencies.length][frequencies.length];
	
	public static void main(String args[]) throws Exception {
		OptimalSearchTree tree = new OptimalSearchTree();
		print2DArray(tree.getSearchTree());
	}
	
	private void init() {
		for (int i = 0; i < results.length; i++) {
			for (int j = 0; j < results[0].length; j++) {
				if (i == j) {
					results[i][j] = frequencies[i];
				} else {
					results[i][j] = 0;
				}
			}
		}
	}
	
	public double[][] getSearchTree() throws Exception {
			init();
			for (int s = 2; s <= frequencies.length; s++) {
				for (int i = 0; i+s-1 < frequencies.length; i++) {
					int j = i + s -1;
					try {
						results[i][j] = getSearchTree(i, j);
					} catch (Exception e) {
						System.out.println("index is " + i + " " + j + "length is " + s + e.getMessage());
						throw e;
					}
				}
			}
		
		return results;
	}
	
	private double getSearchTree(int start, int end) {
		double tmpResult;
		double result = Double.MAX_VALUE;
		for (int i = start; i <= end; i++) {
			double leftSubTree = (start > i - 1 || i - 1 < 0) ? 0 : results[start][i-1];
			double rightSubTree = i + 1 > end ? 0 : results[i+1][end];
			tmpResult = sum(start, end) + leftSubTree + rightSubTree;
			result = Double.compare(result, tmpResult) < 0 ? result : tmpResult;
		}
		return result;
	}
	
	private double sum(int start, int end) {
		double sum = 0;
		for (int i = start; i <= end; i++) {
			sum += frequencies[i];
		}
		
		return sum;
	}
	
	public static void print2DArray(double[][] inputs) {
		for (int i = 0; i < inputs.length; i++) {
			for (int j= 0; j < inputs[0].length; j++ ) {
				System.out.print(inputs[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
