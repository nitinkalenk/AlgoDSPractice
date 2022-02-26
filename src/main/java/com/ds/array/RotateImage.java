package com.ds.array;

public class RotateImage {

  private void swapOneDimArr(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private void swapTwoDimArr(int[][] matrix, int i, int j) {
    int[] arr = matrix[i];
    int temp = arr[j];
    arr[j] = matrix[j][i];
    matrix[j][i] = temp;
  }

  private void transpose(int[][] matrix) {
    for(int i = 0; i < matrix.length; i++) {
      for(int j = i + 1; j < matrix.length; j++) {
        swapTwoDimArr(matrix, i, j);
      }
    }
  }

  private void reverse(int[] arr) {
    int start = 0;
    int end = arr.length - 1;
    while(start < end) {
      swapOneDimArr(arr, start, end);
      start++;
      end--;
    }
  }

  // https://leetcode.com/problems/rotate-image/
  public void rotate(int[][] matrix) {
    transpose(matrix);
    for(int i = 0; i < matrix.length; i++) {
      reverse(matrix[i]);
    }
  }

}
