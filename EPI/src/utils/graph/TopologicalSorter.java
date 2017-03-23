package utils.graph;

/** Created by Pankaj on 11/13/15. */
public class TopologicalSorter {
  private int count;
  private boolean[] visited;
  private int[] ts;

  public TopologicalSorter(DirectedGraph g) {
    visited = new boolean[g.size()];
    ts = new int[g.size()];
    count = g.size();
    for (int v = 0; v < g.size(); v++) {
      if (!visited[v]) tsort(g, v);
    }
  }

  public int[] topologicalOrder() {
    return ts;
  }

  private void tsort(DirectedGraph g, int u) {
    visited[u] = true;
    for (Integer v : g.adj(u)) {
      if (!visited[v]) tsort(g, v);
    }
    ts[--count] = u;
  }
}
