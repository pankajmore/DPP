package utils.graph;

import java.util.*;

/**
 * Created by Pankaj on 12/17/15.
 */
public class DirectedWeightedGraph {
    private final int _numVertices;
    private List<Set<Edge>> _adjacencyList;

    public DirectedWeightedGraph(int numVertices) {
        _numVertices = numVertices;
        _adjacencyList = new ArrayList<>();
        for (int i = 0; i < _numVertices; i++) _adjacencyList.add(new HashSet<>());
    }

    public DirectedWeightedGraph addEdge(int u, int v, int w) {
        _adjacencyList.get(u).add(new Edge(u, v, w));
        return this;
    }

    public Set<Edge> adj(int u) {
        return _adjacencyList.get(u);
    }

    public int size() {
        return _numVertices;
    }

    public int numEdges() {
        return _adjacencyList.stream().map(Set::size).reduce(0, (a, b) -> a + b);
    }

    public DirectedWeightedGraph addEdgeCost(double cost) {
        _adjacencyList.stream().forEach((s) -> s.stream().forEach((edge) -> edge.w += cost));
        return this;
    }

    public int minEdgeWeight() {
        return _adjacencyList.stream().flatMap(Collection::stream).map((e) -> e.w).min(Integer::compare).get();
    }
}
