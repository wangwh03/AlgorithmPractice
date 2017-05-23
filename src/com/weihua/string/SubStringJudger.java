package com.weihua.string;

/*
 * check if one string is the sub string of the other
 * linear scan the first orign string, try to match the second string
 */
public class SubStringJudger {
    public static void main(String[] args) {
        SubStringJudger test = new SubStringJudger();
        System.out.println(test.isSubString("abcde", "b"));
        System.out.println(test.isSubString("abcde", "5"));
    }
    
    public int isSubString(String origin, String subString) {
        for (int i = 0; i < origin.length(); i++) {
            if(isSubString(origin, subString, i)) {
                return i;
            }
        }
        
        return -1;
    }
    
    private boolean isSubString(String origin, String subString, int index) {
        for (int i = 0; i < subString.length(); i++ ) {
            if (!Character.valueOf(origin.charAt(index + i)).equals(subString.charAt(i))) {
                return false;
            }
        }
        
        return true;
    }
}
