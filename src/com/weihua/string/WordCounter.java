package com.weihua.string;

/*
 * Count the number of words in a string
 * keep scanning, and try to get next word index, if this index is a valid index, word counter + 1
 */
public class WordCounter {

	public static void main(String[] args) {
		WordCounter test = new WordCounter();
		System.out.println(test.countWord("ab c  "));
	}
	
	public int countWord(String input) {
		int numberOfWords = 0;

		int i = 0;
		while (i < input.length()) {
			i = getNextWordIndex(i, input);
			if (i != input.length() || input.charAt(input.length() - 1) != ' ') {
				numberOfWords++;
			}
		}
		
		return numberOfWords;
	}
	
	private int getNextWordIndex(int currentIndex, String input) {
		while (currentIndex < input.length() && input.charAt(currentIndex) ==' ') {
			currentIndex++;
		}
		while (currentIndex < input.length() && input.charAt(currentIndex) != ' ') {
			currentIndex++;
		}
		return currentIndex;
	}

}
