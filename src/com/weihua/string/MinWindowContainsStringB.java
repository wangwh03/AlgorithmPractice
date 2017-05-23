package com.weihua.string;
import java.util.HashMap;

/*
 * get the minimum window of string A that contains all chars in string B
 * Basic idea is to find the first window that contains all string B,
 * then maintain this balance by moving to the right, 
 * maintains two tables: charFrequency (desired, based on B)
 * currentFrequency(current when scanning A)
 */
public class MinWindowContainsStringB {

	public static void main(String[] args) {
		MinWindowContainsStringB test = new MinWindowContainsStringB();
		System.out.println(test.getMinLength("ADOBECODEBANC", "ABC"));
	}
	
	public int getMinLength(String input, String T) {
		HashMap<Character, Integer> charFrequency = new HashMap<Character, Integer>();
		
		for (int i = 0; i < T.length(); i++) {
			if (charFrequency.containsKey(T.charAt(i))) {
				charFrequency.put(T.charAt(i), charFrequency.get(T.charAt(i)) + 1);
			} else {
				charFrequency.put(T.charAt(i), 1);
			}
		}
		
		HashMap<Character, Integer> currentFrequency = new HashMap<Character, Integer>();
		
		int leftIndex = 0;
		int rightIndex = 0;
		int counter = 0; // number of satisfied chars 
		int minLength = input.length();
		while (rightIndex < input.length()) {
			if (counter == T.length()) { // if already find the first window, just maintain this balance by moving right, and then move left as right as possible
				if (charFrequency.containsKey(input.charAt(rightIndex))) {
					currentFrequency.put(input.charAt(rightIndex), currentFrequency.get(input.charAt(rightIndex)) + 1);
					while (isConstraintSatisfiedWithoutLeftIndex(charFrequency, currentFrequency, input.charAt(leftIndex))) {
						leftIndex++;
					}
					minLength = Math.min(minLength, rightIndex - leftIndex + 1);
				}
			} else if (charFrequency.containsKey(input.charAt(rightIndex))) {
				// put into current frequency hash map
				if (currentFrequency.containsKey(input.charAt(rightIndex))) {
					currentFrequency.put(input.charAt(rightIndex), currentFrequency.get(input.charAt(rightIndex)) + 1);
				} else {
					currentFrequency.put(input.charAt(rightIndex), 1);
				}
				
				// update counter 
				if (currentFrequency.get(input.charAt(rightIndex)) <= charFrequency.get(input.charAt(rightIndex))) {
					counter++;
					if (counter == T.length()) {
						while (isConstraintSatisfiedWithoutLeftIndex(charFrequency, currentFrequency, input.charAt(leftIndex))) {
							leftIndex++;
						}
						minLength = Math.min(minLength, rightIndex - leftIndex + 1);
					}
				}
			}

			rightIndex++;
		}
		
		return minLength;
	}
	
	// try to move leftIndex to as right as possible
	private boolean isConstraintSatisfiedWithoutLeftIndex(HashMap<Character, Integer> charFrequency, 
			HashMap<Character, Integer> currentFrequency, Character currentChar) {
		if (!charFrequency.containsKey(currentChar)) {
			return true;
		} 
		
		if (currentFrequency.get(currentChar) - charFrequency.get(currentChar) > 0) {
			currentFrequency.put(currentChar, currentFrequency.get(currentChar) - 1);
			return true;
		} else {
			return false;
		}
		
	}
}
