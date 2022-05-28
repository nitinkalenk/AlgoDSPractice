package com.algo.rec;

import java.util.Arrays;

// https://leetcode.com/problems/unique-paths/
public class DistinctPaths {

  private int distinctPaths(int i, int j, int m, int n, int[][] arr) {
    if(i > m || j > n)
      return 0;
    if(i == m && j == n)
      return 1;
    if(arr[i][j] != -1)
      return arr[i][j];
    arr[i][j] = distinctPaths(i + 1, j, m, n, arr) + distinctPaths(i, j + 1, m, n, arr);
    return arr[i][j];
  }

  public int uniquePaths(int m, int n) {
    int[][] arr = new int[m+1][n+1];
    for (int[] row: arr)
      Arrays.fill(row, -1);
    return distinctPaths(1, 1, m, n, arr);
  }

}
