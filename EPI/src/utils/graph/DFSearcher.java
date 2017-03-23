package utils.graph;

/** Created by Pankaj on 11/6/15. */
public class DFSearcher {
  boolean[] visited;

  public DFSearcher(DirectedGraph g, int s) {
    visited = new boolean[g.size()];
    dfs(g, s);
  }

  private void dfs(DirectedGraph g, int u) {
    visited[u] = true;
    for (Integer v : g.adj(u)) {
      if (!visited[v]) dfs(g, v);
    }
  }

  public boolean reachable(int v) {
    return visited[v];
  }
}
