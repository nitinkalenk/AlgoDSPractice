package com.ds.tree;

// inserrtion in BST and check if tree is valid BST
public class BinarySearchTree {

  class Node {
    int val;
    Node left, right;

    Node(int val) {
      this.val = val;
    }
  }

  Node root;

  public void insert(int val) {
    root = insertRec(root, val);
  }

  private Node insertRec(Node root, int val) {
    if (root == null) {
      root = new Node(val);
      return root;
    }
    if (val < root.val)
      root.left = insertRec(root.left, val);
    else if (val > root.val)
      root.right = insertRec(root.right, val);
    return root;
  }

  public boolean isValidBST(Node root) {
    if (root == null)
      return true;
    if (root.left != null) {
      if (!(root.left.val <= root.val)) {
        return false;
      }
    }
    if (root.right != null) {
      if (!(root.right.val > root.val)) {
        return false;
      }
    }
    return isValidBST(root.left) && isValidBST(root.right);
  }

}
