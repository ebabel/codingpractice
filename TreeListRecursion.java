import java.io.*;
import java.util.*;

class TreeListRecusion {
  
  /*
   *            F
   *           / \
   *          /   \
   *         /     \
   *        B       G
   *       / \       \
   *      A   D       I
   *         / \     / \
   *        C   E   H   J
   *               / \   \
   *              L   K   M
   *
   * Pre-order: F, B, A, D, C, E, G, I, H
   * In-order: A, B, C, D, E, F, G, H, I
   * Post-order: A, C, E, D, B, H, I, G, F
   */
  static Node<String> WIKI = new Node<>(null);
  static {
    WIKI.value = "F";
    
    WIKI.left().value = "B";
    WIKI.left().left().value = "A";
    WIKI.left().right().value = "D";
    WIKI.left().right().left().value = "C";
    WIKI.left().right().right().value = "E";
    
    WIKI.right().value = "G";
    WIKI.right().right().value = "I";
    WIKI.right().right().left().value = "H";
    
    WIKI.right().right().right().value = "J";
    WIKI.right().right().left().right().value = "K";
    WIKI.right().right().left().left().value = "L";
    WIKI.right().right().right().right().value = "M";
  }
  
  enum Order {
    PRE_ORDER,
    IN_ORDER,
    POST_ORDER,
  }
  
  static class Node<V> {
    Node<V> parent;
    Node<V> left;
    Node<V> right;
    V value;
    
    Node(Node<V> parent) {
      this.parent = parent;
      this.value = value;
    }
    
    Node<V> left() {
      if (left == null) {
        left = new Node<V>(this);
      }
      return left;
    }
    
    Node<V> right() {
      if (right == null) {
        right = new Node<V>(this);
      }
      return right;
    }
    
    void walk(List<V> list, Order order) {
      if (order == Order.PRE_ORDER) {
        list.add(value);
      }
      
      if (left != null) {
        left.walk(list, order);
      }
      
      if (order == Order.IN_ORDER) {
        list.add(value);
      }
      
      if (right != null) {
        right.walk(list, order);
      }
      
      if (order == Order.POST_ORDER) {
        list.add(value);
      }
    }
    
    @Override
    public String toString() {
      return ""
        + "[parent=" + (parent != null ? parent.value : "NONE") + ", left="
        + (left != null ? left.value : "NONE") + ", right="
        + (right != null ? right.value : "NONE") + "]";
    }
    
    void fromList(List<V> values) {
      List<Node<V>> nodes = new ArrayList<>();
      value = values.get(0);
      nodes.add(this);
      
      for (int i = 1; i < values.size(); i++) {
        Node<V> node = new Node<V>(null);
        node.value = values.get(i);
        nodes.add(node);
      }
      
      for (int i = nodes.size() - 1; i > 0; i--) {
        Node<V> node = nodes.get(i);
        
        int parentIndex = (i + 1) / 2 - 1; // "+ 1" for faux ceil
        Node<V> p = nodes.get(parentIndex);
        node.parent = p;
        
        if (i % 2 != 0) {
          p.left = node;
        } else {
          p.right = node;
        }
        
        println("node(" + node.value + ") = " + node);
      }
      
      println("node(" + nodes.get(0).value + ") = " + nodes.get(0));
      
    }
  }
  
  static <T> void walk(Node<T> root, List<T> list, Order... orders) {
    for (Order order : orders) {
      list.clear();
      root.walk(list, order);
      System.out.println(order + " " + list);
    }
  }
  
  static void println() {
    System.out.println();
  }
    
  static void println(Object o) {
    System.out.println(o);
  }
  
  static void print(Object o) {
    System.out.print(o);
  }
  
  public static void main(String[] args) {
    walk(WIKI, new LinkedList<String>(),
         Order.PRE_ORDER, Order.IN_ORDER, Order.POST_ORDER);
  }
}
