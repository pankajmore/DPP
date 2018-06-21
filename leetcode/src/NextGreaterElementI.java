import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/contest/leetcode-weekly-contest-18b/problems/next-greater-element-i/ Created
 * by pankaj on 05/02/17.
 */
public class NextGreaterElementI {
  public int[] nextGreaterElement(int[] findNums, int[] nums) {
    int[] res = new int[findNums.length];
    Stack<Integer> s = new Stack<>();
    Map<Integer, Integer> ng = new HashMap<>();
    for (int num : nums) {
      while (!s.isEmpty() && s.peek() < num) ng.put(s.pop(), num);
      s.push(num);
    }
    for (int i = 0; i < findNums.length; i++) res[i] = ng.getOrDefault(findNums[i], -1);
    return res;
  }
}
