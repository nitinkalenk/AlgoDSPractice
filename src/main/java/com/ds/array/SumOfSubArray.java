package com.ds.array;

public class SumOfSubArray {

  // https://practice.geeksforgeeks.org/problems/sum-of-subarrays2229
  public static long subarraySum( long a[], long n) {
    long m = 1000000007;
    long sum = 0;
    for(int i = 0; i < n; i++) {
      long contribution = (((((i + 1) % m) * ((n - i) % m)) % m ) * (a[i] % m)) % m;
      sum = (( sum % m ) + (contribution % m)) % m;
    }
    return sum;
  }

}
