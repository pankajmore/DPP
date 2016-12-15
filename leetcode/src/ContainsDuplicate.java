import java.util.HashSet;

/**
 * https://leetcode.com/problems/contains-duplicate/
 * Created by pankaj on 15/12/16.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }
}
