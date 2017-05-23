package com.weihua.longest;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Refactored method is better and for sure linear. Original solution may not be linear
 * @author weihua
 *
 */
public class LongestUqinueSuString {

	public static void main(String[] args) {
		LongestUqinueSuString test = new LongestUqinueSuString();
		System.out.println(test.getMaxUniqueSubString("abca"));
		System.out.println(test.getMaxLenRefactor("abca"));
	}
	
	public int getMaxUniqueSubString(String input) {
		int maxLen = 0;
		int startIndex = 0;
		while(startIndex < input.length()) {
			int[] result = getFirstUniqueSubString(input, startIndex);
			maxLen = Math.max(maxLen, result[0]);
			startIndex = result[1];
		}
		return maxLen;
	}
	
	private int[] getFirstUniqueSubString(String input, int startIndex) {
		if (input == null || input.isEmpty()) {
			return new int[]{0,0};
		}
		
		HashMap<Character, Integer> appearedCharByIndex = new HashMap<Character, Integer>();
		int i = startIndex;
		do {
			appearedCharByIndex.put(input.charAt(i), i);
			i++;
		} while (i < input.length() && !appearedCharByIndex.containsKey(input.charAt(i)));

		int nextIndex = i == input.length()? i : appearedCharByIndex.get(input.charAt(i)) + 1;

		return new int[]{i-startIndex, nextIndex};
	}
	
	/*
	 * Keep linear scanning chars.  If this char does not appear before, just add and increase size by 1
	 * If this char appeared before, add it, move leftIndex to right so that this char is not repeated
	 * Since each char is added and removed once from the maxSubString, this is linear
	 * 
	 */
	public int getMaxLenRefactor(String input) {
		int i = 0;
		int j = 0;
		int maxLen = 0;
		HashSet<Character> appearedChars = new HashSet<Character>();
		while (j < input.length()) {
			if (appearedChars.contains(input.charAt(j))) {
				maxLen = Math.max(maxLen, j-i);
				while (input.charAt(i) != input.charAt(j)) {
					appearedChars.remove(input.charAt(i));
					i++;
				}
				i++;
			} else {
				appearedChars.add(input.charAt(j));
			}
			j++;
		}
		
		maxLen = Math.max(maxLen, input.length() - i);
		return maxLen;
	}

}
