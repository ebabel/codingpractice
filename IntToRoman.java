import java.io.*;
import java.util.*;

/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

Symbol  I  V  X   L   C    D    M
Value   1  5  10  50  100  500  1,000

Notation  IV  IX  XL  XC  CD   CM
Number    4   9   40  90  400  900

899 -> DCCCXCIX
901 -> CMI

Input: 4999
Output: MMMMCMXCIX

Input: 1004
Output: MIV


Input: 4
Output: IV



 */

class Solution {
  static final Map<Integer, String> ROMAN_MAP = new TreeMap<>(Collections.reverseOrder());
  // static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
  // static final String[] ROMAN = { "M", "CM", "D", "CD", "C",
  static {
    ROMAN_MAP.put(1000, "M");
    ROMAN_MAP.put(900, "CM");
    ROMAN_MAP.put(500, "D");
    ROMAN_MAP.put(400, "CD");
    ROMAN_MAP.put(100, "C");
    ROMAN_MAP.put(90, "XC");
    ROMAN_MAP.put(50, "L");
    ROMAN_MAP.put(40, "XL");
    ROMAN_MAP.put(10, "X");
    ROMAN_MAP.put(9, "IX");
    ROMAN_MAP.put(5, "V");
    ROMAN_MAP.put(4, "IV");
    ROMAN_MAP.put(1, "I");
    
  }
  
  public static void main(String[] args) {
    printProblem(4, "IV");
    printProblem(9, "IX");
    printProblem(300, "CCC");
    printProblem(1900, "MCM");
    printProblem(4999, "MMMMCMXCIX");
  }
  
  public static void printProblem(int num, String expected){
     System.out.println("expected:" + expected + ", got:" + intToRoman(num));
    // System.out.println("expected:" + num + ", got:" + romanToInt(expected));
    
  }
  
public static int romanToInt(String s) {
   int sum = 0;

   for (int i = 0; i < s.length(); i++) {
       if (i >= 1) {
          if (s.charAt(i - 1) == 'I' && s.charAt(i) == 'V') { sum -= 2; }
          if (s.charAt(i - 1) == 'I' && s.charAt(i) == 'X') { sum -= 2; }
          if (s.charAt(i - 1) == 'X' && s.charAt(i) == 'L') { sum -= 20; }
          if (s.charAt(i - 1) == 'X' && s.charAt(i) == 'C') { sum -= 20; }
          if (s.charAt(i - 1) == 'C' && s.charAt(i) == 'D') { sum -= 200; }
          if (s.charAt(i - 1) == 'C' && s.charAt(i) == 'M') { sum -= 200; }
       }
       
       if (s.charAt(i) == 'M') sum += 1000;
       if (s.charAt(i) == 'D') sum += 500;
       if (s.charAt(i) == 'C') sum += 100;
       if (s.charAt(i) == 'L') sum += 50;
       if (s.charAt(i) == 'X') sum += 10;
       if (s.charAt(i) == 'V') sum += 5;
       if (s.charAt(i) == 'I') sum += 1;
   }
   
   return sum;
}
  
  
   public static String intToRoman(int number) {
     if (number == 0) {
       return "";
     } else if (number == 1) {
       return "I";
     }
     
     String roman = "";
     int divisor = 1;
     
     for (Map.Entry<Integer, String> entry : ROMAN_MAP.entrySet()) {
       if (number == entry.getKey()) {
         return entry.getValue();
       } else if (number > entry.getKey()) {
         int newNumber;
         if (number - entry.getKey() >= entry.getKey()) {
           newNumber = number - entry.getKey();
         } else {
           newNumber = number % entry.getKey();
         }
         return entry.getValue() + intToRoman(newNumber);
       }
     }
     
     return "";
  }
}
