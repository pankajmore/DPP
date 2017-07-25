import java.util.Arrays;

/** https://leetcode.com/problems/largest-number/ Created by pankaj on 25/07/17. */
class LargestNumber {
  String largestNumber(final int[] nums) {
    String[] xs = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      xs[i] = String.valueOf(nums[i]);
    }
    Arrays.sort(xs, (x, y) -> (y + x).compareTo(x + y));
    StringBuilder sb = new StringBuilder();
    for (String x : xs) {
      sb.append(x);
    }
    return removeLeadingZeroes(sb.toString());
  }

  private String removeLeadingZeroes(final String s) {
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != '0') {
        return s.substring(i, s.length());
      }
    }
    return "0";
  }
}
