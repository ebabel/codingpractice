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
    // A magic index in an array A[1...n-1] is defined to be an index
    // such that A[i] = i. Given a sorted array of distinct integers,
    // write a method to find a magic index, if one exists, in array A.
    int[] intArray = { -111,-11,-10,0,1,2,3, 7};
    findTheMagicElement(intArray);
  }
  
  private static void findTheMagicElement(int[] intArray){
    int startingLocation = Math.round((intArray.length-1) / 2f);
    int seekLocation = startingLocation;
    int segmentLength = Math.round((intArray.length-1) / 4f);
    
    while ( intArray[seekLocation] != seekLocation && segmentLength > 0) {
      
      System.out.println();
      System.out.println("seekLocation: " + seekLocation);
      System.out.println("intArray[seekLocation]: " + intArray[seekLocation]); 
      System.out.println("segmentLength: " + segmentLength);
      
       if ( intArray[seekLocation] < seekLocation ) {
          seekLocation += segmentLength;
       } else {
          seekLocation -= segmentLength;
       }
      
      segmentLength = Math.round(segmentLength / 2f);
      
    }
    if ( intArray[seekLocation] == seekLocation) {
      System.out.println("Magic: " + seekLocation);  
    } else {
      System.out.println("Magic: -1");
    }
  }
}