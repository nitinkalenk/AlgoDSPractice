package com.ds.array;

import com.sun.jdi.connect.Connector;

public class TrappingRainWater {

  // https://leetcode.com/problems/trapping-rain-water/
  public int trap(int[] height) {
    int[] maxPrefixArr = new int[height.length];
    int[] maxSuffixArr = new int[height.length];

    // fill prefix array
    maxPrefixArr[0] = height[0];
    for(int i = 1; i < height.length; i++) {
      maxPrefixArr[i] = Math.max(maxPrefixArr[i - 1], height[i]);
    }

    // fill suffix array
    maxSuffixArr[height.length - 1] = height[height.length - 1];
    for(int i = height.length - 2; i >= 0; i--) {
      maxSuffixArr[i] = Math.max(maxSuffixArr[i + 1], height[i]);
    }

    int waterHeight = 0;
    for(int i = 1; i < height.length - 1; i++) {
      waterHeight += Math.max(Math.min(maxPrefixArr[i - 1], maxSuffixArr[i + 1]) - height[i], 0);
    }
    return waterHeight;
  }


}
