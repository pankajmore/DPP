package com.dpp.geeksforgeeks;

import java.util.Arrays;
import java.util.Scanner;

/**
 * http://practice.geeksforgeeks.org/problems/pythagorean-triplet/0 Created by pankaj on 27/06/17.
 */
final class PythagoreanTriplet {
  private PythagoreanTriplet() {}

  static void main(final String[] args) {
    Scanner in = new Scanner(System.in);
    int numCases = in.nextInt();
    while (numCases-- > 0) {
      int len = in.nextInt();
      int[] nums = new int[len];
      for (int i = 0; i < len; i++) {
        nums[i] = in.nextInt();
      }
      if (hasPythagoreanTriplet(nums)) {
        System.out.println("Yes");
      } else {
        System.out.println("No");
      }
    }
  }

  private static boolean hasPythagoreanTriplet(final int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      nums[i] *= nums[i];
    }
    Arrays.sort(nums);
    for (int i = nums.length - 1; i >= 0; i--) {
      int j = 0;
      int k = i - 1;
      while (j < k) {
        if (nums[j] + nums[k] == nums[i]) {
          return true;
        } else if (nums[j] + nums[k] > nums[i]) {
          k--;
        } else {
          j++;
        }
      }
    }
    return false;
  }
}
