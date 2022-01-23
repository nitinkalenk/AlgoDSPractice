package com.ds.dynamicprog;
// https://www.geeksforgeeks.org/maximum-profit-sale-wines/
public class WineSelling {

  private static int maxProfit(int startIndex, int endIndex, int year, int[] price) {
    if (startIndex > endIndex) {
      return 0;
    }
    int soldFirst = (price[startIndex] * year) + maxProfit(startIndex + 1, endIndex, year + 1, price);
    int soldLast = (price[endIndex] * year) + maxProfit(startIndex, endIndex - 1, year + 1, price);
    return Math.max(soldFirst, soldLast);
  }

  public static void main (String[] args)
  {
    int price[] = { 2, 4, 6, 2, 5 };
    int ans = maxProfit(0, price.length - 1, 1, price);
    System.out.println( ans );
  }

}
