package utils.graph;

import java.util.*;

/**
 * Shortest path finding algorithm
 * Time : O(|E| + |V|log|V|)
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
        PriorityQueue<Integer> unvisited = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (_dist[o1] == null || _dist[o2] == null) {
                    return 0;
                }
                return Double.compare(_dist[o1], _dist[o2]);
            }
        });
        unvisited.add(_source);
        while (!unvisited.isEmpty()) {
            Integer u = unvisited.poll();
            for (Edge edge : _graph.adj(u)) {
                double alternate = _dist[u] + edge.w;
                if (_dist[edge.v] == null || alternate < _dist[edge.v]) {
                    _dist[edge.v] = alternate;
                    _prev[edge.v] = u;
                    if (!unvisited.contains(edge.v))
                        unvisited.add(edge.v);
                }
            }
        }
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
