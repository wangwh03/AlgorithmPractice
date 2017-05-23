package com.weihua.general;

/*
 * check if a string is palindrome or not.  Basically just compare from both ends
 */
public class PalindromeJudger {

    public static void main(String[] args) {
        PalindromeJudger test = new PalindromeJudger();
        System.out.println(test.isPalin("a"));
        System.out.println(test.isPalin("ab"));
        System.out.println(test.isPalin("aba"));
        System.out.println(test.isPalin(1));
        System.out.println(test.isPalin(12));
        System.out.println(test.isPalin(121));
        System.out.println(test.isPalin(12221));
    }
    
    public boolean isPalin(String input) {
        if (input == null || input.length() == 0) {
            return true;
        }
        
        int length = input.length();
        for (int i = 0; i < length / 2; i++) {
            if (!Character.valueOf(input.charAt(i)).equals(input.charAt(length - i -1))) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isPalin(int input) {
        return isPalin(String.valueOf(input));
    }
}
