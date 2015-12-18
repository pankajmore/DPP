package utils.graph;

import java.util.*;

/**
 * Shortest path finding algorithm
 * Time : O(|V|^2)
 * Space: O(|V|)
 */
public class Dijkstra {
    private final DirectedWeightedGraph _graph;
    private final int _source;
    private final Double[] _dist;
    private final Integer[] _prev;

    public Dijkstra(DirectedWeightedGraph graph, int source) {
        _graph = graph;
        _source = source;
        _dist = new Double[_graph.size()];
        _prev = new Integer[_graph.size()];
        run();
    }

    private void run() {
        _dist[_source] = 0.0;
        Set<Integer> unvisited = new HashSet<>();
        for (int i = 0; i < _graph.size(); i++) unvisited.add(i);
        while (!unvisited.isEmpty()) {
            Integer u = findMin(unvisited);
            if (u == null) return;
            unvisited.remove(u);
            for (Edge edge : _graph.adj(u)) {
                double alternate = _dist[u] + edge.w;
                if (_dist[edge.v] == null || alternate < _dist[edge.v]) {
                    _dist[edge.v] = alternate;
                    _prev[edge.v] = u;
                }
            }
        }
    }

    private Integer findMin(Set<Integer> unvisited) {
        Double minDistance = null;
        Integer minVertex = null;
        for (Integer v : unvisited) {
            if (_dist[v] != null) {
                if (minVertex == null || _dist[v] < minDistance) {
                    minVertex = v;
                    minDistance = _dist[v];
                }
            }
        }
        return minVertex;
    }

    public double shortestPath(int v) {
        return _dist[v];
    }

    public List<Integer> shortestPathSequence(Integer v) {
        List<Integer> path = new ArrayList<>();
        while (v != null) {
            path.add(v);
            v = _prev[v];
        }
        Collections.reverse(path);
        return path;
    }
}
