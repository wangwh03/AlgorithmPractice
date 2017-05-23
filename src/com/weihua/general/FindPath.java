package com.weihua.general;

/*
 * ebay interview question from mitbbs
 * given a map 
 * [A B C D E
 * F G H I J
 * K L M N O
 * ...
 * Z], find the path from the starting point to the given string, and the path from char to char inside string
 * For example, starting from M, in order to go to H, print up, then right.  
 * 
 * The trick part is Z where you can only move up
 */
public class FindPath {

	public static void main(String[] args) {
		FindPath test = new FindPath();
		test.printPath("HIZ", 'M');
	}

	public void printPath(String input, char startPoint) {
		int[] startIndece = getIndex(startPoint);
		int rowStart = startIndece[0];
		int colStart = startIndece[1];
		
		for (int i = 0; i < input.length(); i++) {
			int[] indece = getIndex(input.charAt(i));
			int rowIndex = indece[0];
			int colIndex = indece[1];
			if (rowStart != 5) {
				// make sure move to the correct colum first so that going to Z is not a problem
				if (colIndex > colStart) {
					for (int j = colStart; j < colIndex; j++) {
						System.out.print("right ");
					}
				} else if (colIndex < colStart) {
					for (int j = colIndex; j < colStart; j++) {
						System.out.print("left ");
					}
				} 
				if (rowIndex > rowStart) {
					for (int j = rowStart; j < rowIndex; j++) {
						System.out.print("down ");
					}
				} else if (rowIndex < rowStart) {
					for (int j = rowIndex; j < rowStart; j++) {
						System.out.print("up ");
					}
				} 
				rowStart = rowIndex;
				colStart = colIndex;
			} else {
				// starting from Z, since we can only move up from Z, convert this problem by going up one
				// step first.
				if (rowStart == rowIndex && colStart == colIndex) {
				} else {
					rowStart = rowIndex - 1;
					i--;  // do not let i increase
				}
			}
			System.out.println();
		}
	}
	
	private int[] getIndex(char point) {
		int rowStart = (point-'A') / 5;
		int colStart = (point-'A') % 5;
		return new int[]{rowStart, colStart};
	}
}
