/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * Created by pankaj on 28/01/17.
 */
public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int N = numbers.length, i = 0, j = N - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum > target) j--;
            else if (sum < target) i++;
            else return new int[]{i + 1, j + 1};
        }
        return null;
    }
}
