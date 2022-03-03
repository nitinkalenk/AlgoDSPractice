package com.ds.array;

public class SearchMatrix {


  private boolean searchMatrix(int[][] matrix, int i, int j, int target) {
    if(i >= matrix.length || j < 0) {
      return false;
    }
    if(matrix[i][j] == target) {
      return true;
    } else if(target < matrix[i][j]) {
      return searchMatrix(matrix, i , j - 1, target);
    } else {
      return searchMatrix(matrix, i + 1, j, target);
    }
  }

  // https://leetcode.com/problems/search-a-2d-matrix-ii/
  public boolean searchMatrix(int[][] matrix, int target) {
    return searchMatrix(matrix, 0, matrix[0].length - 1, target);
  }

}
