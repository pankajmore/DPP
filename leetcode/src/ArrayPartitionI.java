import java.util.Arrays;

/** https://leetcode.com/problems/array-partition-i/ Created by pankaj on 23/04/17. */
public class ArrayPartitionI {
  public int arrayPairSum(int[] nums) {
    int sum = 0;
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i = i + 2) {
      sum += nums[i];
    }
    return sum;
  }
}
