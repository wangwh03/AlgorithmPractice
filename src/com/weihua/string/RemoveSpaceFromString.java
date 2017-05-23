package com.weihua.string;

public class RemoveSpaceFromString {

	public static void main(String[] args) {
		RemoveSpaceFromString test = new RemoveSpaceFromString();
		System.out.println(test.removeSpace("1 2"));
	}

	public String removeSpace(String input) {
		if (input == null) {
			return null;
		}
		
		String result = "";
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != ' ') {
				// consider to use a stringbuilder instead, because for + each time we need to create a new string
				// which is slow
				result = result + input.charAt(i);
			}
		}
		
		return result;
	}
}
