package com.weihua.general;

/*
 * check if an integer is palindrome integer. You can simply convert this into a string by String.valueOf(Integer)
 * Here this solution directly compares instead of converting to string
 * basically, get the first number, get the last number(mod 10), then compare
 * 
 */
public class PalindromeIntJudger {
    public static void main(String[] args) {
        // Start typing your code here...
        System.out.println("Hello world!");
        
        PalindromeIntJudger test = new PalindromeIntJudger();
        System.out.println(test.isPalindrome(0));
        System.out.println(test.isPalindrome(1221));
        test.isPalindrome(1221);
        System.out.println(test.isPalindrome(123));
    }
    
    public boolean isPalindrome(int input) {
        if (input < 0)
            return false;
        // Marker to help get first digit
        int firstDigitMarker = 1;
        while (input / firstDigitMarker >= 10) {
            firstDigitMarker *= 10;
        }
        
        int reminder = input;
        while (reminder >= 10) {
            int lastDigit = reminder % 10;
            int firstDigit = reminder / firstDigitMarker;
            if (lastDigit != firstDigit) {
                return false;
            } 
            reminder = (reminder - firstDigit * firstDigitMarker) / 10;
            firstDigitMarker /= 100;
        }
        return true;
    }
}