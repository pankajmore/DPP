import java.util.ArrayList;
import java.util.List;

/** https://leetcode.com/problems/all-paths-from-source-to-target/description/ */
class AllPathsFromSourceToTarget {
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> allPaths = new ArrayList<>();
    visit(graph, 0, graph.length - 1, path, allPaths);
    return allPaths;
  }

  private void visit(
      int[][] graph, int src, int dest, List<Integer> path, List<List<Integer>> allPaths) {
    path.add(src);
    if (src == dest) {
      allPaths.add(new ArrayList<>(path));
    } else {
      for (int next : graph[src]) {
        visit(graph, next, dest, path, allPaths);
      }
    }
    path.remove(path.size() - 1);
  }
}
