package com.dpp.geeksforgeeks;

/**
 * http://practice.geeksforgeeks.org/problems/the-celebrity-problem/1 Created by pankaj on 06/07/17.
 */
class TheCelebrityProblem {
  int getId(final int[][] know, final int n) {
    int i = 0, j = n - 1;
    while (i < j) {
      if (know[i][j] == 1) {
        i++;
      } else {
        j--;
      }
    }
    for (int x = 0; x < n; x++) {
      if (x != i) {
        if (know[x][i] == 0 || know[i][x] == 1) {
          return -1;
        }
      }
    }
    return i;
  }
}
