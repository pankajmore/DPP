package puzzles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pankaj on 1/22/16.
 * 1st person opens every door from 1 to N
 * ith person toggles every ith door from door i
 * Find the remaining open doors after N persons have come
 */
public class OpenDoors {
    /**
     * Time : O(sqrt(N))
     * Space : O(sqrt(N))
     *
     * @param N the number of doors. Doors are numbered 1 to N
     * @return the list of doors remaining open
     */
    public static List<Integer> openDoors(int N) {
        List<Integer> openDoors = new ArrayList<>();
        for (int i = 1; i * i <= N; i++) openDoors.add(i * i);
        return openDoors;
    }
}
