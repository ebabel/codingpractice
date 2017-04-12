import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  
  static int top, bottom, left, right;
  static int outputI;
  static int x, y;
  
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    
    // x is the sub array, y is the outer array. Use [y][x]
    int[][] matrix = {
      { 1,    2,   3,   4},
      { 5,    6,   7,   8},
      { 9,   10,  11,  12},
      {13,  14,  15,  16},
      {17,  18,  19,  20}
    };

    bottom = matrix.length - 1;
    right = matrix[0].length-1;
    
    int[] output = new int[matrix.length * matrix[0].length];
    
    while (outputI < (output.length)) {
      
      
      fillRight(matrix, output);
      fillDown(matrix, output);
      fillLeft(matrix, output);
      fillUp(matrix, output);
    }
    
    System.out.println("output:" + Arrays.toString(output));
  }
  
  private static void fillRight(int[][] matrix, int[] output){
     for (; x <= right; x++) {
       
       output[outputI++] = matrix[y][x];
       matrix[y][x] = -1;
     }
    x--;
    y++;
    top++;
    
  }
  private static void fillDown(int[][] matrix, int[] output){
    for (; y <= bottom; y++) {
      output[outputI++] = matrix[y][x];
      matrix[y][x] = -1;
    }
    x--;
    y--;
    right--;
  }
  private static void fillLeft(int[][] matrix, int[] output){
    for (; x >= left; x--) {
      output[outputI++] = matrix[y][x];
      matrix[y][x] = -1;
    }
    y--;
    x++;
    bottom--;
  }
  private static void fillUp(int[][] matrix, int[] output){
    for (; y >= top; y--) {
      output[outputI++] = matrix[y][x];
      matrix[y][x] = -1;
    }
    x++;
    y++;
    left++;
  }
  
  
}
