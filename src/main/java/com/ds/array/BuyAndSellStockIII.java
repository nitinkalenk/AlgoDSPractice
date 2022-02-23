package com.ds.array;

public class BuyAndSellStockIII {

  private int[] getMaxSuffixProfitArr(int[] arr) {
    int[] maxSuffixProfitArr = new int[arr.length];

    maxSuffixProfitArr[arr.length - 1] = 0;
    int max = arr[arr.length - 1];
    for(int i = arr.length - 2; i >= 0; i--) {
      maxSuffixProfitArr[i] = Math.max(maxSuffixProfitArr[i + 1], max - arr[i]);
      max = Math.max(max, arr[i]);
    }
    return maxSuffixProfitArr;
  }

  public int maxProfit(int[] prices) {
    int[] maxSuffixProfitArr = getMaxSuffixProfitArr(prices);

    int min = prices[0];
    int maxProfit = 0;
    for(int i = 1; i < prices.length; i++) {
      int firstTransProfit = Math.max(prices[i] - min, 0);
      int secondTransProfit = i >= prices.length - 1 ? 0 : Math.max(maxSuffixProfitArr[i + 1], 0);
      maxProfit = Math.max(maxProfit, firstTransProfit + secondTransProfit);
      min = Math.min(min, prices[i]);
    }
    return maxProfit;
  }

}
