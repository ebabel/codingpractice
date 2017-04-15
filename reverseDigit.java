import java.io.*;
import java.util.*;

/*
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 
 * Note:
 * The input is assumed to be a 32-bit signed integer. Your function
 * should return 0 when the reversed integer overflows.
 */

class Solution {
  public static int reverse(int x) {
    
    long reverseSolution = 0;
    boolean hasMoreDigits;
    int digit = 1;
    while (hasMoreDigits = x != 0){
      int remainder = x % 10;
      // System.out.println("remainder:"+ remainder);
      x=x/10;
      
      reverseSolution *= Math.pow(10, digit);
      reverseSolution += remainder;
      // System.out.println("reverseSolution:"+ reverseSolution);
      
    }
    
    if (reverseSolution > Integer.MAX_VALUE || reverseSolution < Integer.MIN_VALUE) {
      return 0;
    }
    
    return (int)reverseSolution;
  }
  
  public static void main(String[] args) {
    
    System.out.println(reverse(2147483643));
    
    System.out.println(reverse(-2147483647));
    
    System.out.println(reverse(1234));
    System.out.println(reverse(-123));
    System.out.println(reverse(123));
    
  }
}
