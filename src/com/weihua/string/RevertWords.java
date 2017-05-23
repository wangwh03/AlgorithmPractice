package com.weihua.string;

/*
 * revert words order inside a sentence. 
 * Starting from the end of the sentence, loop through until find a word, append this word into stringbuilder.
 */
public class RevertWords {

	public static void main(String[] args) {
		RevertWords test = new RevertWords();
		System.out.println(test.revert(""));
		System.out.println(test.revert("this is a word"));  // word a is this
	}

	public String revert(String input) {
		if (input == null) {
			return null;
		}
		int i = input.length() - 1;
		StringBuilder stringBuilder = new StringBuilder();
		int currentIndex = input.length() - 1;
		while (i >= 0) {
			while (i >= 0 && input.charAt(i) != ' ') {
				i--;
			}
			stringBuilder.append(input.substring(i+1, currentIndex+1))
						 .append(" ");
			currentIndex = i--;
		}
		return stringBuilder.toString();
	}
}
