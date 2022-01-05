package com.ds.tree;

// https://leetcode.com/problems/deepest-leaves-sum/
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

public class DeepestLeavesSum {

  private int height(TreeNode root) {
    if(root == null)
      return 0;
    return 1 + Math.max(height(root.left), height(root.right));
  }

  private int leafSum(TreeNode root, int height, int currentHeight) {
    if(root == null) {
      return 0;
    } else if(currentHeight == height) {
      return root.val;
    }
    return leafSum(root.left, height, currentHeight + 1) + leafSum(root.right, height, currentHeight + 1);
  }

  public int deepestLeavesSum(TreeNode root) {
    return leafSum(root, height(root), 1);
  }


}
