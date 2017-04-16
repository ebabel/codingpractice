import java.io.*;
import java.util.*;

/*
 * Concerns: 
 *  figuring out optimal Y direction was difficult and took time.
 *  
 * Lessons learned:
 *  optimal approach saved time
 *  never use 'x', or when there is a conflict with iter names and param names, change BOTH
 *  for 2D arrays, storing as [y],[x] is better
 *  use testable methods (no field vars that are hard to keep track of, pass everything)
 *  test often, visual aids help!
 */

class Solution {
  
  private static int TAKEN = 8;
  private static int NOT_TAKEN = 1;
  
  
  public static void drop(int x, int size, int[][] map) {
    int lowestClearY = getLowestClearY(x, size, map[map.length-1]);
    applyShape(x,lowestClearY,size,map);
  }
  
  public static int getLowestClearY(int x, int size, int[] map){
    int lowestClearY = 0;
    for (int xIter = x; xIter < x + size; xIter++) {
      System.out.println(map[xIter]);
      if (map[xIter] > lowestClearY) {
        lowestClearY = map[xIter];
      }
    }
      
    return lowestClearY; 
  }
  
  public static void applyShape(int x, int y, int size, int[][] map) {
    
    for (int yIter = y; yIter < y + size; yIter++) {
      for ( int xIter = x; xIter < x + size; xIter++) {
        System.out.println("@" + xIter + "," + yIter);
        map[yIter][xIter] = TAKEN; 
        
        // store the new lowestClearY in top of map
        map[map.length-1][xIter] = yIter + 1;
      }
    }
    
  }
  
  
  public static void main(String[] args) {
    //                     y,x
    int[][] map = new int[21][10];
    
    // top row is reserved for storing lowest clear row per column
    Arrays.fill(map[20], 0, map[map.length-1].length, 0);
    
    for (int y = 0; y < map.length-1; y++){
      Arrays.fill(map[y], 0, map[y].length, NOT_TAKEN);
    }
      // Test getLowestClearY
//     System.out.println("expecting 3: " + 
//                        getLowestClearY(2,3,new int[] {
//                           6,6,2,3,1,6,6
//                        }));
    
    // visually test dropping squares
    drop(0,2, map);
    drop(1,2, map);
    drop(0,2, map);
    drop(2,2, map);
    
    // visually test applyShape
    // applyShape(2,2,2,map);
    
    System.out.println("Lowest clear y:");
    System.out.println(Arrays.toString(map[map.length-1]));
    System.out.println("");
    
    for (int y = map.length-2; y >= 0; y--){
      System.out.println(Arrays.toString(map[y]));
    }
  }
}
