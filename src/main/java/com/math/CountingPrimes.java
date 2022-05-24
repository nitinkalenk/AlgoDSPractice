package com.math;

import java.util.Scanner;

public class CountingPrimes {

  private static int[] getSeivesArray() {
    int[] primes = new int[1000000 + 1];
    for(int i = 2; i < primes.length; i++) {
      primes[i] = 1;
    }
    for(int i = 2; i * i < primes.length; i++) {
      if(primes[i] == 1) {
        for(int j = i * i; j < primes.length && j > 0; j = j + i) {
          primes[j] = 0;
        }
      }
    }
    for(int i = 1; i < primes.length; i++) {
      primes[i] = primes[i] + primes[i - 1];
    }
    return primes;
  }

  public static void main (String[] args) throws java.lang.Exception
  {
    int[] seives = getSeivesArray();
    Scanner scanner = new Scanner(System.in);
    int noOfTestCases = scanner.nextInt();
    while(noOfTestCases-- > 0) {
      int number = scanner.nextInt();
      System.out.println(seives[number]);
    }
  }

}
