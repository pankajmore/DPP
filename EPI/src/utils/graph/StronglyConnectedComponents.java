package utils.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by Pankaj on 11/14/15.
 */
public class StronglyConnectedComponents {
    private boolean[] visited;
    private Stack<Integer> stack;
    private Set<Set<Integer>> sccs;

    public StronglyConnectedComponents(DirectedGraph g) {
        visited = new boolean[g.size()];
        sccs = new HashSet<>();
        stack = new Stack<>();
        for (int u = 0; u < g.size(); u++)
            if (!visited[u]) dfs(g, u, false, null);
        for (int u = 0; u < g.size(); u++) visited[u] = false;
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (!visited[u]) {
                Set<Integer> scc = new HashSet<>();
                sccs.add(scc);
                dfs(g.transpose(), u, true, scc);
            }
        }
    }

    public Set<Set<Integer>> sccs() {
        return sccs;
    }

    private void dfs(DirectedGraph g, int u, boolean transpose, Set<Integer> scc) {
        visited[u] = true;
        g.adj(u).stream().filter(v -> !visited[v]).forEach(v -> dfs(g, v, transpose, scc));
        if (transpose) scc.add(u);
        else stack.push(u);
    }

}
