import java.util.HashSet;

/** https://leetcode.com/problems/intersection-of-two-arrays/ Created by pankaj on 10/12/16. */
public class IntersectionOfTwoArrays {
  public int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> s1 = new HashSet<>(), c = new HashSet<>();
    for (int x : nums1) s1.add(x);
    for (int x : nums2) if (s1.contains(x)) c.add(x);
    int[] res = new int[c.size()];
    int i = 0;
    for (int x : c) res[i++] = x;
    return res;
  }
}
