package com.ds.array;

// https://practice.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847
public class MinSwaps {


  private static int getWindowSize(int[] arr, int k) {
    int count = 0;
    for(int i = 0; i < arr.length; i++) {
      count = arr[i] <= k ? count + 1 : count;
    }
    return count;
  }

  public static int minSwap (int arr[], int n, int k) {
    int windowSize = getWindowSize(arr, k);
    int numCountBelowOrEqualK = 0;
    for(int i = 0; i < windowSize ; i++) {
      numCountBelowOrEqualK = arr[i] <= k ? numCountBelowOrEqualK + 1 : numCountBelowOrEqualK;
    }
    int minSwap = windowSize - numCountBelowOrEqualK;
    for(int i = windowSize; i < arr.length ; i++) {
      numCountBelowOrEqualK = arr[i - windowSize] <= k ? numCountBelowOrEqualK - 1 : numCountBelowOrEqualK;
      numCountBelowOrEqualK = arr[i] <= k ? numCountBelowOrEqualK + 1 : numCountBelowOrEqualK;
      minSwap = Math.min(minSwap, windowSize - numCountBelowOrEqualK);
    }
    return minSwap;
  }

  public static void main(String[] args) {
    System.out.println(minSwap(new int[] {8, 13, 7, 6, 4, 8, 5, 15, 11, 13, 18}, 11, 9));
  }

}
