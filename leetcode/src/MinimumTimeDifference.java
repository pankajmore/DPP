import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** https://leetcode.com/problems/minimum-time-difference/ Created by pankaj on 12/03/17. */
public class MinimumTimeDifference {
  public int findMinDifference(List<String> timePoints) {
    List<Integer> ts = new ArrayList<>();
    for (String s : timePoints) {
      int hh = Integer.valueOf(s.substring(0, 2));
      int mm = Integer.valueOf(s.substring(3, 5));
      ts.add(hh * 60 + mm);
    }
    Collections.sort(ts);
    int min = 24 * 60, N = timePoints.size();
    for (int i = 1; i < N; i++) {
      int t1 = ts.get(i - 1);
      int t2 = ts.get(i);
      int diff = t2 - t1;
      min = Math.min(min, diff);
    }
    min = Math.min(min, ts.get(0) - ts.get(N - 1) + 24 * 60);
    return min;
  }
}
