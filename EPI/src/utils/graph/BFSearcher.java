package utils.graph;

import java.util.LinkedList;
import java.util.Queue;

/** Created by Pankaj on 11/7/15. */
public class BFSearcher {
  boolean[] visited;

  public BFSearcher(DirectedGraph g, int s) {
    visited = new boolean[g.size()];
    bfs(g, s);
  }

  private void bfs(DirectedGraph g, int s) {
    Queue<Integer> q = new LinkedList<>();
    q.add(s);
    while (!q.isEmpty()) {
      Integer u = q.poll();
      visited[u] = true;
      for (Integer v : g.adj(u)) if (!visited[v]) q.add(v);
    }
  }

  public boolean isReachable(int v) {
    return visited[v];
  }
}
