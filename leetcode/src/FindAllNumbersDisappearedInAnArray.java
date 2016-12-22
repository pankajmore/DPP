import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * Created by pankaj on 22/12/16.
 */
public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int N = nums.length;
        List<Integer> l = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        for (int x = 1; x <= N; x++) {
            if (!set.contains(x)) l.add(x);
        }
        return l;
    }
}
