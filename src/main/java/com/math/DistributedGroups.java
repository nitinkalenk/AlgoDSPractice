package com.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DistributedGroups
{

  private static int getGcd(int num1, int num2) {
    int min = Math.min(num1, num2);
    int max = Math.max(num1, num2);
    while(max % min != 0) {
      int temp = min;
      min = max % min;
      max = min;
    }
    return min;
  }

  private static Map<Integer, Integer> toOccurenceMap(int[] arr) {
    Map<Integer, Integer> numToOccurenceMap = new HashMap();
    for(int num: arr) {
      numToOccurenceMap.merge(num, 1, (oldValue, newValue) -> oldValue + newValue);
    }
    return numToOccurenceMap;
  }

  private static boolean canBeDistributed(int[] arr) {
    List<Integer> occurences= new ArrayList(toOccurenceMap(arr).values());
    int gcd = occurences.get(0);
    for(int i = 1; i < occurences.size(); i++) {
      gcd = getGcd(gcd, occurences.get(i));
      if(gcd == 1) {
        return false;
      }
    }
    return gcd >= 2;
  }

  public static void main (String[] args) throws java.lang.Exception
  {
    Scanner scanner = new Scanner(System.in);
    int noOfTestCases = scanner.nextInt();
    while(noOfTestCases-- != 0) {
      int size = scanner.nextInt();
      int[] arr = new int[size];
      for(int i = 0; i < size; i++) {
        arr[i] = scanner.nextInt();
      }
      System.out.println(canBeDistributed(arr));
    }
  }
}
