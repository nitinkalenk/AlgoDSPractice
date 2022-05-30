package com.algo.rec;

import java.util.ArrayList;
import java.util.List;

public class SetsOfSubset {

  public List<List<Integer>> subsets(int[] nums) {
    int noOfSubsets = 1 << nums.length;
    List<List<Integer>> ans = new ArrayList();
    for(int i = 0; i < noOfSubsets; i++) {
      ans.add(new ArrayList());
    }
    for(int i = 0; i < noOfSubsets; i++) {
      for(int j = 0; j < nums.length; j++) {
        if(((i >> j) & 1) != 0){
          ans.get(i).add(nums[j]);
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    runBinEquiLoop(8);
  }

  private static void runBinEquiLoop(int num) {
    while (num != 0) {
      System.out.println("Run");
      num = num >> 1;
    }
  }

}
