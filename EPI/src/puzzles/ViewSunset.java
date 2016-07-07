package puzzles;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by pankaj on 7/7/16.
 */
public class ViewSunset {
    public static Deque<BuildingWithHeight> examineBuildingsWithSunset(Iterator<Integer> heights) {
        Deque<BuildingWithHeight> buildingsWithSunset = new LinkedList<>();
        int id = 0;
        while (heights.hasNext()) {
            id++;
            int currHeight = heights.next();
            while (!buildingsWithSunset.isEmpty() && buildingsWithSunset.peek().height <= currHeight) {
                buildingsWithSunset.pop();
            }
            buildingsWithSunset.push(new BuildingWithHeight(id++, currHeight));
        }
        return buildingsWithSunset;
    }

    static class BuildingWithHeight {
        int id;
        int height;

        public BuildingWithHeight(int id, int height) {
            this.id = id;
            this.height = height;
        }
    }
}
