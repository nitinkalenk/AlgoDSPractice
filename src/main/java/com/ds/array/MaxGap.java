package com.ds.array;

import java.lang.management.MemoryType;
import java.util.Arrays;

public class MaxGap {

  private static int getMaxGap(int[] arr) {
    // get min and max
    int min = arr[0];
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      min = Math.min(min, arr[i]);
      max = Math.max(max, arr[i]);
    }

    // calculate gap
    int gap = ((max - min) % (arr.length - 1)) == 0 ? (max - min) / (arr.length - 1) : ((max - min) / (arr.length - 1)) + 1;

    // create max min bucket array
    int[] minArr = new int[arr.length];
    int[] maxArr = new int[arr.length];
    fillMaxMinArr(arr, minArr, maxArr, min, gap);

    return getMaxDiff(minArr, maxArr);
  }

  private static int getMaxDiff(int[] minArr, int[] maxArr) {
    int max = maxArr[0];
    int maxDiff = 0;
    for (int i = 1; i < minArr.length; i++) {
      maxDiff = Math.max(minArr[i] - max, maxDiff);
      max = maxArr[i] == 0 ? max : maxArr[i];
    }
    return maxDiff;
  }

  private static void fillMaxMinArr(int[] arr, int[] minArr, int[] maxArr, int min, int gap) {
    for (int i = 0; i < arr.length; i++) {
      int bucketIndex = (arr[i] - min) / gap;
      minArr[bucketIndex] = minArr[bucketIndex] == 0 ? arr[i] : Math.min(minArr[bucketIndex], arr[i]);
      maxArr[bucketIndex] = Math.max(maxArr[bucketIndex], arr[i]);
    }
  }

  public static void main(String[] args) {
    System.out.println(getMaxGap(new int[] { 20, 25, 27, 33, 65, 70 }));
  }

}
