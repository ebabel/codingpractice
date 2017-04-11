import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class StringRotation {
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("String Rotation!");
    
    String one = "waterbottle";
    String two = "terbottaewa";
    
    
    System.out.println(isRotation(one, two));

    
  }
  
  private static boolean isRotation(String one, String two) {
    if (one.length() != two.length()) {
      return false;
    }
    
    return isSubstring(one.concat(one), two);
    
  }
  
  private static boolean isSubstring(String one, String two) {
    return one.contains(two);  
    
  }
}