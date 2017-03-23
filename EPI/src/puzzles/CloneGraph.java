package puzzles;

import java.util.*;

/**
 * Created by pankaj on 3/18/16.
 *
 * <p>Clones a directed graph, handles self-loops and cycles as well.
 */
public class CloneGraph {
  /**
   * Time : O(|V| + |E|) Space: O(|V|)
   *
   * @param g a directed graph with |V| vertices and |E| edges
   * @return a deep-copy of the g
   */
  public static DirectedGraph clone(DirectedGraph g) {
    if (g == null) return null;
    Map<DirectedGraph, DirectedGraph> vertexMap = new HashMap<>();
    Queue<DirectedGraph> q = new LinkedList<>();
    q.add(g);
    vertexMap.put(g, new DirectedGraph(g.val));
    while (!q.isEmpty()) {
      DirectedGraph u = q.remove();
      for (DirectedGraph v : u.neighbors) {
        if (!vertexMap.containsKey(v)) {
          vertexMap.put(v, new DirectedGraph(v.val));
          q.add(v);
        }
        vertexMap.get(u).neighbors.add(vertexMap.get(v));
      }
    }
    return vertexMap.get(g);
  }

  public static class DirectedGraph {
    int val;
    List<DirectedGraph> neighbors;

    DirectedGraph(int val) {
      this.val = val;
      neighbors = new ArrayList<>();
    }

    public static Set<DirectedGraph> bfs(DirectedGraph g) {
      Set<DirectedGraph> set = new HashSet<>();
      Queue<DirectedGraph> q = new LinkedList<>();
      q.add(g);
      while (!q.isEmpty()) {
        DirectedGraph u = q.remove();
        u.neighbors
            .stream()
            .filter(v -> !set.contains(v))
            .forEach(
                v -> {
                  set.add(v);
                  q.add(v);
                });
      }
      return set;
    }

    public boolean deepEquals(DirectedGraph g) {
      Set<DirectedGraph> original = bfs(this);
      Set<DirectedGraph> copy = bfs(g);
      return original.containsAll(copy) && copy.containsAll(original);
    }

    @Override
    public boolean equals(Object o) {
      if (o == null || !(o instanceof DirectedGraph)) return false;
      DirectedGraph g = (DirectedGraph) o;
      return this.val == g.val;
    }

    @Override
    public int hashCode() {
      return this.val;
    }
  }
}
