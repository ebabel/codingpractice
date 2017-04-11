import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    // Implement a function to check if a linked list is a palindrome.
    
    LinkedList<String> linkedList = new LinkedList<>();
    linkedList.add("onae");
    linkedList.add(null);
    
    linkedList.add(null);
    linkedList.add("onae");
    
    
    
    System.out.println(isPalindrome(linkedList));
  }
  
  static boolean isPalindrome(LinkedList<String> list) {
    if ( list.isEmpty() ) {
      return false;
    }
    
    int top = 0;
    int bottom = list.size() - 1;
    
    
    
    while (top <= bottom) {
      if ( list.get(top).equals(list.get(bottom))) {
        top++;
        bottom--;
      } else {
        return false;
      }
    }
    
    return true;
  }
}

