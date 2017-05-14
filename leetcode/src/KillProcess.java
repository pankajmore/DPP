import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** https://leetcode.com/problems/kill-process/ Created by pankaj on 14/05/17. */
class KillProcess {
  List<Integer> killProcess(final List<Integer> pid, final List<Integer> ppid, final int kill) {
    Map<Integer, List<Integer>> pMap = new HashMap<>();
    for (int i = 0; i < pid.size(); i++) {
      int parent = ppid.get(i);
      int child = pid.get(i);
      if (!pMap.containsKey(parent)) {
        pMap.put(parent, new ArrayList<>());
      }
      pMap.get(parent).add(child);
    }
    List<Integer> desc = new ArrayList<>();
    findDesc(kill, pMap, desc);
    return desc;
  }

  private void findDesc(
      final int root, final Map<Integer, List<Integer>> tree, final List<Integer> desc) {
    desc.add(root);
    for (int c : tree.getOrDefault(root, new ArrayList<>())) {
      findDesc(c, tree, desc);
    }
  }
}
