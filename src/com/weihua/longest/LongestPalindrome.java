package com.weihua.longest;

public class LongestPalindrome {

	public static void main(String[] args) {
		LongestPalindrome test = new LongestPalindrome();
		System.out.println(test.getLongestPalinString("abaabcdcba"));
	}
	
	public String getLongestPalinString(String input) {
		int length = input.length();
		boolean[][] isPalin = new boolean[length][length];
		// init
		for (int i = 0; i < length; i++) {
			isPalin[i][i] = true;
		}
		
		for (int i = 0; i < length-1; i++) {
			isPalin[i][i+1] = input.charAt(i) == input.charAt(i+1); //check substring
		}
		
		for (int s = 3; s <= length; s++) {
			for (int i = 0; i + s - 1 < length; i++) {
				int j = i + s -1;
				isPalin[i][j] = isPalin[i+1][j-1] && input.charAt(i) == input.charAt(j); //check equals
			}
		}
		
		int maxLen = 0;
		int leftIndex = 0;
		int rightIndex = 0;
		for (int s = 1; s <= length; s++) {
			for (int i = 0; i+s-1 < length; i++) {
				int j = i + s - 1;
				if (isPalin[i][j] && s > maxLen) {
					maxLen = s;
					leftIndex = i;
					rightIndex = j;
				}
			}
		}
		
		return input.substring(leftIndex, rightIndex+1);
	}
}
