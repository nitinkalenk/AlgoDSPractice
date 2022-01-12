package com.ds.tree;

// https://leetcode.com/problems/recover-binary-search-tree/
public class RecoverBST {

  TreeNode firstElement = null;
  TreeNode secondElement = null;
  TreeNode previous = null;

  private void inOrder(TreeNode root) {
    if(root == null) {
      return;
    }
    inOrder(root.left);
    if(previous != null) {
      if(firstElement == null && previous.val > root.val) {
        firstElement = previous;
      }
      if(firstElement != null && previous.val > root.val) {
        secondElement = root;
      }
    }
    previous = root;
    inOrder(root.right);
  }

  public void recoverTree(TreeNode root) {
    inOrder(root);
    int temp = firstElement.val;
    firstElement.val = secondElement.val;
    secondElement.val = temp;
  }

}
