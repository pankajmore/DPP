package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/** https://www.interviewbit.com/problems/order-of-people-heights/ Created by pankaj on 09/03/17. */
public class OrderOfPeopleHeights {
  /** Time: O(N^2), Space: O(N) */
  public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts) {
    int N = heights.size();
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < N; i++) map.put(heights.get(i), infronts.get(i));
    Collections.sort(heights);
    ArrayList<Integer> order = new ArrayList<>(Collections.nCopies(N, -1));
    for (Integer height : heights) {
      int idx = 0, cnt = map.get(height);
      while (cnt > 0) {
        if (order.get(idx++) == -1) {
          cnt--;
        }
      }
      while (order.get(idx) != -1) {
        idx++;
      }
      order.set(idx, height);
    }
    return order;
  }
}
