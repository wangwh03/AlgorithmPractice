package com.weihua.longest;

public class MaxSubarraySumCalculator {

	public static void main(String[] args) {
		int[] testNumbers = {1, -2, 
				3, 5, 6, -2, -1, 4, 
				-4, 2, -1};
		System.out.println(getMaxSum(testNumbers));
		
		MaxSumResult result = getMaxSumLinearTime(testNumbers);
		System.out.println(result.getLeftIndex() + "\t" 
				+ result.getRightIndex() + "\t" 
				+ result.getMaxSum());
	}
	
	/**
	 * pure dp
	 */
	static MaxSumResult getMaxSumLinearTime(int[] numbers) {
		// max(including n) = max{max(including n-1) + numbers[n], numbers[n]}     (i,n) , n
		// max(n) = max{max(n-1), max(including n)}   i,k      
		int currentMaxSum = numbers[0];   //0,0
		int currentMaxSumIncludingCurrentNumber = numbers[0]; //0,0
		int leftIndex = 0;
		int rightIndex = 0;
		int leftIndexIncludingCurrent = 0;
		for (int i = 1; i < numbers.length; i++) {
			if (currentMaxSumIncludingCurrentNumber + numbers[i] > numbers[i]) {
				currentMaxSumIncludingCurrentNumber = currentMaxSumIncludingCurrentNumber + numbers[i];
			} else {
				currentMaxSumIncludingCurrentNumber = numbers[i];
				leftIndexIncludingCurrent = i;
			}
			
			if (currentMaxSum < currentMaxSumIncludingCurrentNumber) {
				currentMaxSum = currentMaxSumIncludingCurrentNumber;
				leftIndex = leftIndexIncludingCurrent;
				rightIndex = i;
			}
		}
		
		return new MaxSumResult(leftIndex, rightIndex, currentMaxSum);
	}
	
	/**
	 *  Divide and conquer, nlogn
	 */
	private static int getMaxSum(int[] numbers) {
		return _getMaxSum(numbers, 0, numbers.length -1);
	}
	
	private static int _getMaxSum(int[] numbers, int l, int r) {
		if (l == r) {
			return numbers[l];
		}
		
		int m = (l + r) / 2;
		int leftMax = _getMaxSum(numbers, l, m);
		int rightMax = _getMaxSum(numbers, m + 1, r);
		int crossMax = getCrossMax(numbers, l, m, r);
		return Math.max(crossMax, Math.max(leftMax, rightMax));
	}
	
	private static int getCrossMax(int[] numbers, int l, int m, int r) {
		int currentSum = 0;
		int rightMaxSum = Integer.MIN_VALUE;
		for (int i = m + 1; i <= r; i++) {
			currentSum += numbers[i];
			if (currentSum > rightMaxSum) {
				rightMaxSum = currentSum;
			}
		}
		
		currentSum = 0;
		int leftMaxSum = Integer.MIN_VALUE;
		for (int i = m; i >=l; i--) {
			currentSum += numbers[i];
			if (currentSum > leftMaxSum) {
				leftMaxSum = currentSum;
			}
		}
		
		return rightMaxSum + leftMaxSum;
	}
	
	public static class MaxSumResult {
		int leftIndex;
		int rightIndex;
		int maxSum;
		
		public MaxSumResult(int leftIndex, int rightIndex, int maxSum) {
			this.leftIndex = leftIndex;
			this.rightIndex = rightIndex;
			this.maxSum = maxSum;
		} 
		
		public int getLeftIndex() {
			return leftIndex;
		}
		public void setLeftIndex(int leftIndex) {
			this.leftIndex = leftIndex;
		}
		public int getRightIndex() {
			return rightIndex;
		}
		public void setRightIndex(int rightIndex) {
			this.rightIndex = rightIndex;
		}
		public int getMaxSum() {
			return maxSum;
		}
		public void setMaxSum(int maxSum) {
			this.maxSum = maxSum;
		}
	}
}

