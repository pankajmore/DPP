package utils.graph;

/**
 * Created by Pankaj on 11/8/15.
 */
public class CycleDetector {
    private boolean[] visited;
    private boolean[] done;
    private boolean dag;

    public CycleDetector(DirectedGraph g) {
        visited = new boolean[g.size()];
        done = new boolean[g.size()];
        dag = true;
        for (int v = 0; v < g.size(); v++)
            if (!visited[v])
                dag &= search(g, v);
    }

    private boolean search(DirectedGraph g, int u) {
        visited[u] = true;
        for (Integer v : g.adj(u)) {
            if (!visited[v]) return search(g, v);
            else if (!done[v]) return false;
        }
        done[u] = true;
        return true;
    }

    public boolean isDAG() {
        return dag;
    }
}
