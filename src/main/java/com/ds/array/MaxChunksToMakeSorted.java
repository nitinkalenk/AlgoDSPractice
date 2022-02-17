package com.ds.array;

public class MaxChunksToMakeSorted {

  // https://leetcode.com/problems/max-chunks-to-make-sorted/submissions/
  public int maxChunksToSorted(int[] arr) {
    int max = -1;
    int maxChunks = 0;
    for(int i = 0; i < arr.length; i++) {
      max = Math.max(max, arr[i]);
      if(max == i) {
        maxChunks++;
      }
    }
    return maxChunks;
  }

}
