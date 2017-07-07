package com.dpp.geeksforgeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** https://leetcode.com/problems/queue-reconstruction-by-height/ Created by pankaj on 07/07/17. */
class QueueReconstructionByHeight {
  int[][] reconstructQueue(final int[][] people) {
    int n = people.length;
    int[][] actualOrder = new int[n][2];
    Arrays.fill(actualOrder, null);
    Arrays.sort(
        people,
        (x, y) -> {
          if (x[0] == y[0]) {
            return x[1] - y[1];
          } else {
            return x[0] - y[0];
          }
        });
    for (int[] p : people) {
      int h = p[0];
      int k = p[1];
      int idx = 0;
      int c = 0;
      while (c < k) {
        if (actualOrder[idx] == null || actualOrder[idx][0] >= h) {
          c++;
        }
        idx++;
      }
      while (actualOrder[idx] != null) {
        idx++;
      }
      actualOrder[idx] = p;
    }
    return actualOrder;
  }

  int[][] reconstructQueue1(final int[][] people) {
    int n = people.length;
    Arrays.sort(
        people,
        (x, y) -> {
          if (x[0] == y[0]) {
            return x[1] - y[1];
          } else {
            return y[0] - x[0];
          }
        });
    List<int[]> order = new ArrayList<>();
    for (int[] p : people) {
      order.add(p[1], p);
    }
    int[][] res = new int[n][2];
    for (int i = 0; i < n; i++) {
      res[i] = order.get(i);
    }
    return res;
  }
}
