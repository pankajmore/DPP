import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/** https://leetcode.com/problems/minimum-index-sum-of-two-lists/ Created by pankaj on 28/05/17. */
class MinimumIndexSumOfTwoLists {
  String[] findRestaurant(final String[] list1, final String[] list2) {
    HashMap<String, Integer> map = new HashMap<>();
    int minIdxSum = list1.length + list2.length;
    List<String> res = new ArrayList<>();
    for (int i = 0; i < list1.length; i++) {
      String s = list1[i];
      map.put(s, i);
    }
    for (int i = 0; i < list2.length; i++) {
      String s = list2[i];
      if (map.containsKey(s)) {
        if (map.get(s) + i < minIdxSum) {
          minIdxSum = map.get(s) + i;
          res.clear();
          res.add(s);
        } else if (map.get(s) + i == minIdxSum) {
          res.add(s);
        }
      }
    }
    return res.toArray(new String[res.size()]);
  }
}
