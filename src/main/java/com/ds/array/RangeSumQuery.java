package com.ds.array;

//https://leetcode.com/problems/range-sum-query-2d-immutable
public class RangeSumQuery {

  class NumMatrix {
    private final int[][] prefixSumMatrix;

    public NumMatrix(int[][] matrix) {
      convertToPrefixSumMatrix(matrix);
      this.prefixSumMatrix = matrix;
    }

    private void convertToPrefixSumArray(int[] arr) {
      for(int i = 1; i < arr.length; i++) {
        arr[i] = arr[i] + arr[i - 1];
      }
    }

    private void convertToPrefixSumMatrix(int[][] matrix) {
      for(int i = 0; i < matrix.length; i++) {
        convertToPrefixSumArray(matrix[i]);
      }
    }

    private int sumSubArray(int[] arr, int i, int j) {
      return arr[j] - (i == 0 ? 0 : arr[i - 1]);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
      int sum = 0;
      for(int i = row1; i <= row2; i++) {
        sum += sumSubArray(prefixSumMatrix[i], col1, col2);
      }
      return sum;
    }
  }

}
