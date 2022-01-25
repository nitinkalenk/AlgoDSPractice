package com.ds.dynamicprog;

import java.util.HashSet;
import java.util.Set;

public class GoodWaysToSplitString {

  // https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
  public int numSplits(String s) {
    Set<Character> pSet = new HashSet();
    Set<Character> qSet = new HashSet();
    int[] prefix = new int[s.length()];
    int[] suffix = new int[s.length()];

    for (int i = 0; i < s.length(); i++) {
      pSet.add(s.charAt(i));
      qSet.add(s.charAt(s.length() - 1 - i));
      prefix[i] = pSet.size();
      suffix[s.length() - 1 - i] = qSet.size();
    }

    int ans = 0;
    for (int i = 1; i < prefix.length; i++) {
      if (prefix[i - 1] == suffix[i]) {
        ans++;
      }
    }
    return ans;
  }



}