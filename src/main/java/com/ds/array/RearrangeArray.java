package com.ds.array;

import java.util.Arrays;

// https://www.geeksforgeeks.org/rearrange-array-arrj-becomes-arri-j/
public class RearrangeArray {

  public static void rearrangeArr() {
    int[] arr = new int[] { 1, 3, 0, 2 };
    for(int i = 0; i < arr.length; i++) {
      int oldValue = arr[i] % arr.length;
      arr[oldValue] = i * 4 + arr[oldValue];
    }
    for(int i=0; i < arr.length;i++) {
      arr[i] = arr[i] / arr.length;
    }
    System.out.println(Arrays.toString(arr));
  }

  public static void main(String[] args) {
    rearrangeArr();
  }

}
