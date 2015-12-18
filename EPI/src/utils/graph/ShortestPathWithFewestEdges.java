package utils.graph;

import java.util.List;

/**
 * Created by Pankaj on 12/18/15.
 */
public class ShortestPathWithFewestEdges {
    private final Dijkstra _dijkstra;

    public ShortestPathWithFewestEdges(DirectedWeightedGraph graph, Integer source) {
        DirectedWeightedGraph _graph = graph.addEdgeCost(graph.minEdgeWeight() / (graph.numEdges() + 1));
        _dijkstra = new Dijkstra(_graph, source);
    }

    public double shortestPath(int v) {
        return _dijkstra.shortestPath(v);
    }

    public List<Integer> shortestPathSequence(int v) {
        return _dijkstra.shortestPathSequence(v);
    }
}
