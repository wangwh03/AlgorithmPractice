package com.weihua.longest;

public class LongestPalindromeForInterview {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestPalindromeForInterview test = new LongestPalindromeForInterview();
		System.out.println(test.getLongestPalindrome("abcb"));
	}
	
	public String getLongestPalindrome(String input) {
		if (input == null || input.length() == 0) {
			return input;
		}
		
		String maxSubString = "";
		for (int i = 0; i < input.length() - 1; i++) {
			String maxLenCenterI = getMaxLen(input, i);
			if (maxSubString.length() < maxLenCenterI.length()) {
				maxSubString = maxLenCenterI;
			}
			
			maxLenCenterI = getMaxLen(input, i, i+1);
			if (maxSubString.length() < maxLenCenterI.length()) {
				maxSubString = maxLenCenterI;
			}
		}
		
		return maxSubString;
		
	}
	
	private String getMaxLen(String input, int i) {
		return getMaxLen(input, i, i);
	}
	
	private String getMaxLen(String input, int i, int j) {
		String maxSubString = "";
		int len = 0;
		while(i-len >= 0 && j+len < input.length() && input.charAt(i-len) == input.charAt(j+len)) {
			maxSubString = input.substring(i-len, j+len+1);
			len++;
		}
		return maxSubString; 
	}
}
