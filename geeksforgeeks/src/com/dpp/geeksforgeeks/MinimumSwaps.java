package com.dpp.geeksforgeeks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** http://practice.geeksforgeeks.org/problems/minimum-swaps/1 Created by pankaj on 26/06/17. */
class MinimumSwaps {
  int minSwaps(final int[] nums, final int len) {
    int[] sorted = nums.clone();
    Arrays.sort(sorted);
    Map<Integer, Integer> idx = new HashMap<>();
    for (int i = 0; i < len; i++) {
      idx.put(sorted[i], i); // assume distinct
    }
    boolean[] visited = new boolean[len];
    int numSwaps = 0;
    for (int i = 0; i < len; i++) {
      if (!visited[i]) {
        int cycleSize = 1;
        visited[i] = true;
        int curr = idx.get(nums[i]);
        while (curr != i) {
          visited[curr] = true;
          cycleSize++;
          curr = idx.get(nums[curr]);
        }
        numSwaps += cycleSize - 1;
      }
    }
    return numSwaps;
  }
}
