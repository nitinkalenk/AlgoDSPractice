package com.ds.array;

public class MaxVowels {

  private boolean isVowel(char ch) {
    return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
  }

  // https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
  public int maxVowels(String s, int k) {
    int maxVowelCount = 0;
    for(int i = 0; i < k; i++) {
      maxVowelCount = isVowel(s.charAt(i)) ? maxVowelCount + 1 : maxVowelCount;
    }
    int prevStrVowelCount = maxVowelCount;
    for(int i = k; i < s.length(); i++) {
      int currentStrVowelCount = isVowel(s.charAt(i - k)) ? prevStrVowelCount - 1 : prevStrVowelCount;
      currentStrVowelCount = isVowel(s.charAt(i)) ? currentStrVowelCount + 1 : currentStrVowelCount;
      maxVowelCount = Math.max(maxVowelCount, currentStrVowelCount);
      prevStrVowelCount = currentStrVowelCount;
    }
    return maxVowelCount;
  }

}
