package com.ds.tree;

import java.util.ArrayList;
import java.util.List;

public class TwoSumBST {
  private boolean findTarget(List<Integer> list, int target) {
    int low = 0, high = list.size() - 1;
    while(low < high) {
      int smallNo = list.get(low);
      int bigNo = list.get(high);
      int sum = smallNo + bigNo;
      if(sum == target) {
        return true;
      } else if(sum > target) {
        high --;
      } else {
        low++;
      }
    }
    return false;
  }

  private void inOrder(TreeNode root, List<Integer> list) {
    if(root == null) {
      return;
    }
    inOrder(root.left, list);
    list.add(root.val);
    inOrder(root.right, list);
  }

  // https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
  public boolean findTarget(TreeNode root, int k) {
    List<Integer> list = new ArrayList();
    inOrder(root, list);
    return findTarget(list, k);
  }

}
