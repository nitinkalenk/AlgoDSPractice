package com.ds.array;

import static java.lang.Math.max;

import java.util.Arrays;

public class MaximizeExpression {

  /*
  Maximize Expression p*arr[i] + q*arr[j] + k*arr[k]
  such that i < j < k
  p, q, r can be negative or positive
   */
  private static int getMaxValue(int[] arr, int p, int q, int r) {
    int[] prefixArr = new int[arr.length];
    int[] suffixArr = new int[arr.length];
    // fill prefix array
    prefixArr[0] = arr[0] * p;
    for (int i = 1; i < arr.length; i++) {
      prefixArr[i] = max(prefixArr[i - 1], arr[i] * p);
    }
    // fill suffix array
    suffixArr[arr.length - 1] = arr[arr.length - 1] * r;
    for (int i = arr.length - 2; i >= 0; i--) {
      suffixArr[i] = max(suffixArr[i + 1], arr[i] * r);
    }

    int ans = Integer.MIN_VALUE;
    int maxPrefix = p * arr[0];
    for (int i = 1; i < arr.length - 1; i++) {
      ans = max(ans, maxPrefix + q * arr[i] + suffixArr[i + 1]);
      maxPrefix = max(maxPrefix, arr[i] * p);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] arr = new int[] {3, 4, 2, 5, 1, -7, 9};
    System.out.println(getMaxValue(arr, 1, 1, 1)); // 18
    System.out.println(getMaxValue(arr, 1, -2, 1)); // 28
  }

}
