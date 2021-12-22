package com.ds.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

  static class Node {
    Node right;
    Node left;
    final int value;

    Node(int value) {
      this.value = value;
    }
  }

  public static void inOrder(Node root) {
    if (root == null)
      return;
    inOrder(root.left);
    System.out.print(root.value + " ");
    inOrder(root.right);
  }

  public static void preOrder(Node root) {
    if (root == null)
      return;
    System.out.print(root.value + " ");
    preOrder(root.left);
    preOrder(root.right);
  }

  public static void postOrder(Node root) {
    if (root == null)
      return;
    postOrder(root.left);
    postOrder(root.right);
    System.out.print(root.value + " ");
  }

  public static void iterativePreOrder(Node root) {
    Stack<Node> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      Node top = stack.pop();
      System.out.print(top.value + " ");
      if (top.right != null)
        stack.push(top.right);
      if (top.left != null)
        stack.push(top.left);
    }
  }

  public static void iterativeInOrder(Node root) {
    Stack<Node> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      Node top = stack.pop();
      if(top.left == null && top.right == null)
        System.out.print(top.value + " ");
      else if (top.left == null) {
       stack.push(top.right);
       top.right = null;
       stack.push(top);
      } else {
        Node leftNode = top.left;
        top.left = null;
        stack.push(top);
        stack.push(leftNode);
      }
    }
  }

  public static int height(Node root) {
    if (root == null)
      return 0;
    return 1 + Math.max(height(root.left), height(root.right));
  }

  public static void invert(Node root) {
    if (root == null)
      return;
    invert(root.left);
    invert(root.right);
    Node left = root.left;
    root.left = root.right;
    root.right = left;
  }

  public static void bfs(Node root) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      Node node = queue.remove();
      int size = queue.size();
      while (size-- != 0) {
        System.out.print(node.value + " ");
        if (node.left != null)
          queue.add(node.left);
        if (node.right != null)
          queue.add(node.right);
      }
      System.out.println();
    }
  }

  public static boolean isBST(int leftRange, int rightRange, Node root) {
    if (root == null)
      return true;
    if (root.value < leftRange || root.value > rightRange)
      return false;
    return isBST(leftRange, root.value - 1, root.left) && isBST(root.value + 1, rightRange, root.right);
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    Node node5 = new Node(5);
    root.left = node2;
    root.right = node3;
    node2.left = node4;
    node2.right = node5;
    /*
    inOrder(root);
    System.out.println();
    preOrder(root);
    System.out.println();
    postOrder(root);
    System.out.println();

    System.out.println(height(root));
    System.out.println();

    invert(root);
    inOrder(root);
    System.out.println();

    bfs(root);
    iterativeInOrder(root);
     */


  }

}
