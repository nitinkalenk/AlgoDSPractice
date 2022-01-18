package com.ds.dynamicprog;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

  private static List<Integer> getNext(List<Integer> list) {
    List<Integer> ans = new ArrayList<>();
    ans.add(1);
    for (int i = 0; i < list.size() - 1; i++) {
      ans.add(list.get(i) + list.get(i + 1));
    }
    ans.add(1);
    return ans;
  }

  private static List<Integer> getRow(int index) {
    if (index == 1)
      return List.of(1);
    else {
      List<Integer> ans = List.of(1);
      for (int i = 1; i <= index; i++) {
        ans = getNext(ans);
      }
      return ans;
    }
  }

  public static void main(String[] args) {
    //
    System.out.println(getRow(2));
    System.out.println(getRow(3));
    System.out.println(getRow(4));
    System.out.println(getRow(5));
  }

}
