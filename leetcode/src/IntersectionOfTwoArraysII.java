import java.util.ArrayList;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * Created by pankaj on 16/12/16.
 */
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums1) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        ArrayList<Integer> c = new ArrayList<>();
        for (int x : nums2) {
            if (map.containsKey(x)) {
                c.add(x);
                map.put(x, map.get(x) - 1);
                if (map.get(x) == 0) map.remove(x);
            }
        }
        int[] res = new int[c.size()];
        int i = 0;
        for (int x : c) res[i++] = x;
        return res;
    }
}
