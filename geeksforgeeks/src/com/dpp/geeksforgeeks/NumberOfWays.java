package com.dpp.geeksforgeeks;

import java.util.Scanner;

/** http://practice.geeksforgeeks.org/problems/number-of-ways/0 Created by pankaj on 21/04/17. */
public class NumberOfWays {
  public static long fib4(int N) {
    if (N < 4) return 1;
    long a = 1, b = 1, c = 1, d = 2;
    for (int i = 5; i <= N; i++) {
      long tmp = d + a;
      a = b;
      b = c;
      c = d;
      d = tmp;
    }
    return d;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    while (T-- > 0) {
      int N = in.nextInt();
      System.out.println(fib4(N));
    }
  }
}
