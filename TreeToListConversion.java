import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 
 
          1
      /       \
    2          3
  /   \      /    \
4      5    6      7
 
 "In-order" 
 <= 4 <=> 2 <=> 5 <=> 1 <=> 6 <=> 3 <=> 7 => 
 
Post-order walk: [8, 9, 4, 5, 2, 6, 7, 3, 1]
Level-order walk: [1, 2, 3, 4, 5, 6, 7, 8, 9]
 
 */

class Solution {
  
  
  public static class TreeNode<T> {
    T id;
    TreeNode<T> right;
    TreeNode<T> left;
    TreeNode<T> parent;
    
    public TreeNode(T id, TreeNode<T> left, TreeNode<T> right) {
      this(id);
      this.left = left;
      this.right = right;
      
      left.parent = this;
      right.parent = this;
    }
    public TreeNode(T id) {
      this.id = id;
    }
    
    public void inOrderWalk(LinkedList<T> list){
      if ( this.left != null ) {
        this.left.inOrderWalk(list);
      }
      list.add(this.id);
      if ( this.right != null ) {
         this.right.inOrderWalk(list);
      }
    }
    
    public void preOrderWalk(LinkedList<T> list){
      list.add(this.id);
      if ( this.left != null ) {
        this.left.preOrderWalk(list);
      }
      if ( this.right != null ) {
         this.right.preOrderWalk(list);
      }
    }
    
    public void postOrderWalk(LinkedList<T> list){
      if ( this.left != null ) {
        this.left.postOrderWalk(list);
      }
      if ( this.right != null ) {
         this.right.postOrderWalk(list);
      }
      list.add(this.id);
    }
    
    public void levelOrderWalk(LinkedList<T> output){
      List<TreeNode<T>> workingList = new ArrayList<>();
      workingList.add(this);
      int iter = 0;
      while (iter < workingList.size()) {
        TreeNode<T> node = workingList.get(iter);
        output.add(node.id);
        
        if ( node.left != null ) {
          workingList.add(node.left);
        }
        if ( node.right != null ) {
          workingList.add(node.right);
        }
        
        iter++;
      }
      
    }
    
    public void printAll(){
      List<TreeNode<T>> workingList = new ArrayList<>();
      workingList.add(this);
      int iter = 0;
      int level = 1;
      while (iter < workingList.size()) {
        TreeNode<T> node = workingList.get(iter);
        System.out.print(node.id + " ");
        
        if ( node.left != null ) {
          workingList.add(node.left);
        }
        if ( node.right != null ) {
          workingList.add(node.right);
        }
        int mersenne = ((int)Math.pow(2,level)) - 1;
        
        if ( iter == mersenne - 1) {
          System.out.println(" level:"+ level + " iter:"+iter + " mersenne:" + mersenne);
          level++; 
        }
        
        iter++;
        
      }
      System.out.println();
      
    }
    
    
    public String toString() {
      return ""+id;
    }
  }
  
  public static void main(String[] args) {
    
    TreeNode<Integer> a9 = new TreeNode<>(9);
    TreeNode<Integer> a8 = new TreeNode<>(8);
    TreeNode<Integer> a7 = new TreeNode<>(7);
    TreeNode<Integer> a6 = new TreeNode<>(6);
    TreeNode<Integer> a5 = new TreeNode<>(5);
    TreeNode<Integer> a4 = new TreeNode<>(4, a8, a9);
    TreeNode<Integer> a3 = new TreeNode<>(3, a6, a7);
    TreeNode<Integer> a2 = new TreeNode<>(2, a4, a5);
    TreeNode<Integer> a0 = new TreeNode<>(1, a2, a3);

    
    LinkedList<Integer> list = new LinkedList<>();

    LinkedList<TreeNode<Integer>> queue = new LinkedList<>();
    
    TreeNode<Integer> root = null;
    for (int i = 1; i < 8; i++) {
      list.add(i);
      TreeNode<Integer> node = new TreeNode<>(i);
      TreeNode<Integer> first = null;
      if (!queue.isEmpty()) {
         first = queue.get(0);
      }
      queue.add(node);
      
      if ( first != null) {
        if (first.left == null) {
          first.left = node;
        } else if (first.right == null) {
          first.right = node;
        } else {
          queue.remove(first);
          first = queue.get(0);
          first.left = node;
        }
      }
      
      if ( root == null) {
        root = node;
      }
    }
    list.clear();
    
    
    root.printAll();
    
    
    list.clear();
    root.preOrderWalk(list);
    System.out.println("Pre-order walk: " + list);
    list.clear();
    
    root.inOrderWalk(list);
    System.out.println("In-order walk: " + list);
    list.clear();
    
    root.postOrderWalk(list);
    System.out.println("Post-order walk: " + list);
    list.clear();
    
    
    root.levelOrderWalk(list);
    System.out.println("Level-order walk: " + list);
    list.clear();
    
    
    
  }
  
  
}
