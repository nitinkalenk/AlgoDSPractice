package com.algo;

public class Recursion {

  public static void print2(int number) {
    if (number == 0)
      return;
    print2(number - 1);
    System.out.println(number);
  }

  public static void print(int start, int end) {
    if (start == end) {
      System.out.println(start);
      return;
    }
    print(start, end - 1);
    System.out.println(end);
  }

  public static void main(String[] args) {
    //print(1, 10);
    print2(10);
  }

}
