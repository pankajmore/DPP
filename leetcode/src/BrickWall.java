import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Created by pankaj on 09/04/17. */
public class BrickWall {
  public int leastBricks(List<List<Integer>> wall) {
    if (wall == null || wall.size() == 0) return 0;
    int M = wall.size();
    Map<Integer, Integer> cnt = new HashMap<>();
    for (int i = 0; i < M; i++) {
      int sum = 0;
      for (int j = 0; j < wall.get(i).size(); j++) {
        if (j != 0) cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
        sum += wall.get(i).get(j);
      }
    }
    return M - (cnt.isEmpty() ? 0 : Collections.max(cnt.values()));
  }
}
