package puzzles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pankaj on 1/11/16.
 */
public class PowerSet {
    public static List<List<Integer>> generatePowerSet(List<Integer> A) {
        List<List<Integer>> powerSet = new ArrayList<>();
        if (A.size() == 0) {
            powerSet.add(new ArrayList<>());
            return powerSet;
        }
        List<List<Integer>> prevSubsets = generatePowerSet(A.subList(0, A.size() - 1));
        powerSet.addAll(prevSubsets);
        for (List<Integer> subset : prevSubsets) {
            List<Integer> newSubset = new ArrayList<>();
            newSubset.addAll(subset);
            newSubset.add(A.get(A.size() - 1));
            powerSet.add(newSubset);
        }
        return powerSet;
    }
}
