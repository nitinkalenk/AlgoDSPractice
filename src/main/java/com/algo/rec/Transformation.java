package com.algo.rec;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Transformation {

  private static boolean canBeTransformed(long currentNumber, long target, List<Long> transformations) {
    if (currentNumber == target) {
      transformations.add(currentNumber);
      return true;
    } else if (currentNumber > target)
      return false;
    if (canBeTransformed(currentNumber * 2, target, transformations) || canBeTransformed(currentNumber * 10 + 1, target, transformations)) {
      transformations.add(currentNumber);
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long initialNumber = scanner.nextLong();
    long target = scanner.nextLong();
    List<Long> transformations = new ArrayList<>();
    if (!canBeTransformed(initialNumber, target, transformations)) {
      System.out.println("NO");
    } else {
      System.out.println("YES");
      System.out.println(transformations.size());
      for (int i = transformations.size() - 1; i >=0; i--) {
        System.out.print(transformations.get(i) + " ");
      }
    }
  }

}
