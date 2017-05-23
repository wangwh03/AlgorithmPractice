package com.weihua.general;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * Given a dictionary, and a word, find all anagram of this word inside the dictionary
 * preprocess the dictionary to build a hash map, where key is sorted word, value is a list of anagram
 * 
 */
public class AnagramFinder {
    public static void main(String[] args) {
        AnagramFinder test = new AnagramFinder();
        System.out.println(test.getAnagram(null, "cat"));

        List<String> dict = new LinkedList<String>();
        dict.add("cat");
        dict.add("tac");
        dict.add("hat");
        dict.add("anagram");
        System.out.println(test.getAnagram(dict, "anagram"));
    }
    
    public List<String> getAnagram(List<String> dictionary, String word) {
        if (dictionary == null) {
            return null;
        }
        HashMap<String, List<String>> preprocessedDictionary = preprocess(dictionary);
        return preprocessedDictionary.get(sortWord(word));
    }
    
    private HashMap<String, List<String>> preprocess(List<String> dictionary) {
        HashMap<String, List<String>> processedDictionary = new HashMap<String, List<String>>();
        for (String word : dictionary) {
            String sortedWord = sortWord(word);
            if (processedDictionary.containsKey(sortedWord)) {
                processedDictionary.get(sortedWord).add(word);
            } else {
                List<String> anagram = new LinkedList<String>();
                anagram.add(word);
                processedDictionary.put(sortedWord, anagram);
            }
        }
        
        return processedDictionary;
    }
    
    private String sortWord(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        String sortedWord = String.valueOf(chars);
        return sortedWord;
    }
}
