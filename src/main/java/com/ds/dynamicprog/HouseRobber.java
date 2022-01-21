package com.ds.dynamicprog;

import java.util.Arrays;

public class HouseRobber {

  // https://leetcode.com/problems/house-robber/submissions/
  private int rob(int houseNo, int[] moneyArr, int[] dp) {
    if(houseNo >= moneyArr.length) {
      return 0;
    }
    if (dp[houseNo] != -1) {
      return dp[houseNo];
    }
    int currentHouseRobbed = moneyArr[houseNo] + rob(houseNo + 2, moneyArr, dp);
    int currentHouseNotRobbed = rob(houseNo + 1, moneyArr, dp);
    dp[houseNo] = Math.max(currentHouseRobbed, currentHouseNotRobbed);
    return dp[houseNo];
  }

  public int rob(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, -1);
    return rob(0, nums, dp);
  }

}
