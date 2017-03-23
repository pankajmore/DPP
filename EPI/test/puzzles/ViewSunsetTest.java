package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.generator.InRange;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;
import puzzles.ViewSunset.BuildingWithHeight;

import java.util.Deque;
import java.util.List;

import static org.junit.Assert.assertTrue;

/** Created by pankaj on 7/7/16. */
@RunWith(Theories.class)
public class ViewSunsetTest {

  @Theory
  public void checkBuildingsWithSunset(@ForAll @InRange(minInt = 1) List<Integer> heights) {
    if (heights.isEmpty()) return;
    final Deque<BuildingWithHeight> buildingWithHeights =
        ViewSunset.examineBuildingsWithSunset(heights.iterator());
    BuildingWithHeight prev = buildingWithHeights.removeLast();
    while (!buildingWithHeights.isEmpty()) {
      BuildingWithHeight curr = buildingWithHeights.removeLast();
      assertTrue(prev.id < curr.id);
      assertTrue(prev.height > curr.height);
      prev = curr;
    }
  }
}
