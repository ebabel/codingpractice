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
 */

class Solution {
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<>();
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
    
    strings.add("tree");
    strings.add("used");
    strings.add("usaed");

    String sequence = "" + 8733;
    for (String stringToTry : strings) {
      for ( int i = 0; i < sequence.length(); i++) {
        System.out.println("sequence.charAt(i)" + sequence.charAt(i));
        char[] charArrayToTry = numPad[Character.getNumericValue(sequence.charAt(i))];
      
        if (!containsChar(charArrayToTry, stringToTry.charAt(i))) {
          break;
        }
        if (i == sequence.length() - 1){
          System.out.println("word matches: " + stringToTry);
        }
      }
    }
  }
  
  
  public static boolean containsChar(char[] charArrayToTry, char myChar){
    for (int j = 0; j < charArrayToTry.length; j++){
          if ( charArrayToTry[j] == myChar) {
            return true;
          }
        }
    return false;
  }
}
