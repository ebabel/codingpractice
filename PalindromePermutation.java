import java.io.*;
import java.util.*;

class PalindromePermutation {
  public static void main(String[] args) {
    System.out.println(isPermutationOfPalindrome("tact cao"));
  }
  
  public static boolean isPermutationOfPalindrome(String phrase) {
    int[] letters = new int['z'];
    char[] chars = phrase.toCharArray();
    
    int length = 0;
    for (int i = 0; i < chars.length; i++) {
      System.out.println(chars[i]);
      if (chars[i] != ' ') {
        letters[chars[i]]++;
        length++;
      }
    }
    
    int evenCount = 0;
    int oddCount = 0;
    for (int i = 0; i < letters.length; i++) {
      if (letters[i] == 0) continue;
      
      if (letters[i] % 2 == 0) {
        evenCount++;
      } else {
        oddCount++;
      }
    }
    
    boolean isEvenLength = length % 2 == 0;
    if (!isEvenLength && oddCount == 1) {
      return true;
    }
    if (isEvenLength && oddCount == 0) {
      return true;
    }
    
    //System.out.println("letters = " + Arrays.toString(letters));
    return false;
  }
}
