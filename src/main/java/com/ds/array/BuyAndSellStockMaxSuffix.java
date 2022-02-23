package com.ds.array;

public class BuyAndSellStockMaxSuffix {

  private int[] getMaxSuffixArr(int[] arr) {
    int[] maxSuffixArr = new int[arr.length];
    maxSuffixArr[arr.length - 1] = arr[arr.length - 1];
    for(int i = arr.length - 2; i >= 0; i--) {
      maxSuffixArr[i] = Math.max(arr[i], maxSuffixArr[i + 1]);
    }
    return maxSuffixArr;
  }

  // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int[] maxSuffixArr = getMaxSuffixArr(prices);
    for(int i = 0; i < prices.length - 1; i++) {
      maxProfit = Math.max(maxProfit, maxSuffixArr[i + 1] - prices[i]);
    }
    return maxProfit;
  }


  public int maxProfitV2(int[] prices) {
    int min = prices[0];
    int maxProfit = 0;
    for(int i = 1; i < prices.length; i++) {
      maxProfit = Math.max(maxProfit, prices[i] - min);
      min = Math.min(min, prices[i]);
    }
    return maxProfit;
  }

}
