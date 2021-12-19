package com.ds.tree;

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

  public static void main(String[] args) {
    Node root = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    Node node5 = new Node(5);
    Node node6 = new Node(6);
    Node node7 = new Node(7);
    root.left = node2;
    root.right = node3;
    node2.left = node4;
    node2.right = node5;
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

  }

}
