package com.ds.array;


import java.util.Scanner;

//https://codeforces.com/problemset/problem/740/B
public class MaxHappiness {

  private static final Scanner scanner = new Scanner(System.in);

  private static int[] readMoodArr(int moodArrSize) {
    int[] moodArr = new int[moodArrSize];
    for (int i = 0; i < moodArrSize; i++)
      moodArr[i] = scanner.nextInt();
    return moodArr;
  }

  private static int getHappiness(int[] moodArr, int[] prefixSumArr, int start, int end) {
    return prefixSumArr[end] - prefixSumArr[start] + moodArr[start];
  }

  private static int[] getPrefixSumArray(int[] moodArr) {
    int[] prefixSumArr = new int[moodArr.length];
    prefixSumArr[0] = moodArr[0];
    for (int i = 1; i < moodArr.length; i++) {
      prefixSumArr[i] = prefixSumArr[i-1] + moodArr[i];
    }
    return prefixSumArr;
  }

  public static void main(String[] args) {
    int moodArraySize = scanner.nextInt();
    int noOfSubArrays = scanner.nextInt();
    int[] moodArr = readMoodArr(moodArraySize);
    int[] prefixSumArr = getPrefixSumArray(moodArr);
    int maxHappiness = 0;
    while (noOfSubArrays-- > 0) {
      int start = scanner.nextInt();
      int end = scanner.nextInt();
      int happiness = getHappiness(moodArr, prefixSumArr, start - 1, end - 1);
      maxHappiness = happiness > 0 ? maxHappiness + happiness : maxHappiness;
    }
    System.out.println(maxHappiness);
  }

}
