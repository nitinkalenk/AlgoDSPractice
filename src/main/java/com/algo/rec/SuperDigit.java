package com.algo.rec;

public class SuperDigit {

  private static long digitSum(long number) {
    long sum = 0;
    while(number != 0) {
      sum = sum + (number % 10);
      number = number / 10;
    }
    return sum;
  }

  private static long digitSum(String number) {
    long sum = 0;
    for(int i = 0; i < number.length(); i++) {
      sum += Character.getNumericValue(number.charAt(i));
    }
    return sum;
  }

  public static long superDigit(long number) {
    if(number < 10)
      return number;
    return superDigit(digitSum(number));
  }

  public static int superDigit(String n, int k) {
    long initialSuperDigit = digitSum(n) * k;
    return (int)superDigit(initialSuperDigit);
  }

}
