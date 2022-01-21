package com.ds.dynamicprog;

public class AliceAndBobStones {

  // https://www.youtube.com/watch?v=5-lL9QuTpRA&t=3121s
  private static int game(int start, int end, int[] stones) {
    if (start > end)
      return 0;
    int op1 = stones[start] - game(start + 1, end, stones);
    int op2 = stones[end] - game(start, end - 1, stones);
    return Math.max(op1, op2);
  }

  public static void main(String[] args) {
    int[] stones = { 1, 2, 4, 7, 8 };
    int ans = game(0, stones.length -1, stones);
    if (ans > 0) {
      System.out.println("Alice Won");
    }
  }

}
