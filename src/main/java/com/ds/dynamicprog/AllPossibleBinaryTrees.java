package com.ds.dynamicprog;

import java.util.ArrayList;
import java.util.List;

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

// https://leetcode.com/problems/all-possible-full-binary-trees/
public class AllPossibleBinaryTrees {
  public List<TreeNode> allPossibleFBT(int n) {
    if( n%2 == 0 || n <= 0) {
      return new ArrayList();
    }
    List<TreeNode> res = new ArrayList();
    if(n == 1) {
      res.add(new TreeNode(0));
      return res;
    }
    for(int i = 1; i < n; i += 2) {
      List<TreeNode> leftSubTrees = allPossibleFBT(i);
      List<TreeNode> rightSubTrees = allPossibleFBT(n - i - 1);
      for(TreeNode leftNode: leftSubTrees) {
        for(TreeNode rightNode: rightSubTrees) {
          TreeNode root = new TreeNode(0);
          root.right = rightNode;
          root.left = leftNode;
          res.add(root);
        }
      }
    }
    return res;
  }

}
