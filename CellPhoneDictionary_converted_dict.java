import java.io.*;
import java.util.*;

/*
 * On old cell phones, users typed on a numeric keypad and the phone would provide a
 * list of words that matched these numbers. Each digit mapped to a set of 0-4 letters.
 * Implement an algorithm to return a list of matching words, given a sequence of
 * digits. You are provided a list of valid words (provided in whatever data structure
 * you'd like). The mapping is shown in the diagram below:
 *
 * |-----|-----|-----|
 * |  1  |  2  |  3  |
 * |     | abc | def |
 * |-----|-----|-----|
 * |  4  |  5  |  6  |
 * | ghi | jkl | mno |
 * |-----|-----|-----|
 * |  7  |  8  |  9  |
 * | pqrs| tuv | wxyz|
 * |-----|-----|-----|
 * |     |  0  |     |
 * |-----|-----|-----|
 *
 * pg 184
 
 time complexity = a single O(n^2) for converting the dictionary but can be reused with O(1)
 */

class Solution {
  public static void main(String[] args) {
    ArrayList<String> dictionary = new ArrayList<>();
    char[][] numPad =
    {
      {},
      {},
      {'a','b','c'},
      {'d','e','f'},
      {'g','h','i'},
      {'j','k','l'},
      {'m','n','o'},
      {'p','q','r','s'},
      {'t','u','v'},
      {'w','x','y','z'}
    };
    
      dictionary.add("tree");
      dictionary.add("used");

    Map<Integer, List<String>> intStringArrayMap = new HashMap<>();
      
    Map<Character, Integer> numPadMap = new HashMap<>();
    
    for (int i = 2; i < numPad.length; i++) {
      char[] nums = numPad[i];
      for( char num : nums) {
        numPadMap.put(num, i);
      }
    }
    
    
    for (String word : dictionary) {
      String builder = "";
      for(char letter : word.toCharArray()){
        builder += numPadMap.get(letter);
      }
      List<String> entry = intStringArrayMap.get(Integer.valueOf(builder));
      
      if (entry == null) {
        
        entry = new ArrayList<>();  
        intStringArrayMap.put(Integer.valueOf(builder), entry);
      }
        
      entry.add(word);
        
      System.out.println("builder: " + builder);
    }
    
    
    int sequence =  8733;
      List<String> foundWords = intStringArrayMap.get(sequence);
      if ( foundWords != null) {
        System.out.println("Found words: " + Arrays.toString(foundWords.toArray()));
      } else {
        System.out.println("No words found.");
      }
  }
  
  
}