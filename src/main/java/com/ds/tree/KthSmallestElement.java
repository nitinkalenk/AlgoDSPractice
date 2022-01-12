package com.ds.tree;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class KthSmallestElement {

  int count = 0;
  int ans = 0;

  private void inOrder(TreeNode root, int pos) {
    if (root == null) {
      return;
    }
    inOrder(root.left, pos);
    if (++count == pos) {
      ans = root.val;
    }
    inOrder(root.right, pos);
  }

  public int kthSmallest(TreeNode root, int k) {
    inOrder(root, k);
    return ans;
  }

}
