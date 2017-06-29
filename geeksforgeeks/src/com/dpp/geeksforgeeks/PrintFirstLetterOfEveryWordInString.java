package com.dpp.geeksforgeeks;

import java.util.Scanner;

/**
 * http://practice.geeksforgeeks.org/problems/print-first-letter-of-every-word-in-the-string/0
 * Created by pankaj on 29/06/17.
 */
class PrintFirstLetterOfEveryWordInString {
  static void main(final String[] args) {
    Scanner in = new Scanner(System.in);
    int numCases = in.nextInt();
    in.nextLine();
    while (numCases-- > 0) {
      String s = in.nextLine();
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
          sb.append(s.charAt(i));
        }
      }
      System.out.println(sb.toString());
    }
  }
}
