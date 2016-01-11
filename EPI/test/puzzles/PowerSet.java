package puzzles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pankaj on 1/11/16.
 */
public class PowerSet {
    public static List<List<Integer>> generatePowerSet(List<Integer> A) {
        List<List<Integer>> powerSet = new ArrayList<>();
        if (A.size() == 1) {
            powerSet.add(new ArrayList<>());
            List<Integer> singleton = new ArrayList<>();
            singleton.add(A.get(0));
            powerSet.add(singleton);
            return powerSet;
        }
        for (List<Integer> set : generatePowerSet(A.subList(0, A.size() - 1))) {
            List<Integer> s1 = new ArrayList<>(), s2 = new ArrayList<>();
            for (Integer x : set) {
                s1.add(x);
                s2.add(x);
            }
            s2.add(A.get(A.size() - 1));
            powerSet.add(s1);
            powerSet.add(s2);
        }
        return powerSet;
    }
}
