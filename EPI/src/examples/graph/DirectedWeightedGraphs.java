package examples.graph;

import utils.graph.DirectedWeightedGraph;

/**
 * Created by Pankaj on 12/18/15.
 */
public class DirectedWeightedGraphs {
    public static final DirectedWeightedGraph bookExample = new DirectedWeightedGraph(14)
            .addEdge(0, 1, 3).addEdge(0, 2, 2)
            .addEdge(1, 0, 4).addEdge(1, 10, 1)
            .addEdge(2, 4, 8)
            .addEdge(3, 2, 5).addEdge(3, 7, 5)
            .addEdge(4, 3, 7)
            .addEdge(5, 6, 6)
            .addEdge(6, 5, 7).addEdge(6, 7, 4)
            .addEdge(8, 9, 6)
            .addEdge(9, 5, 1).addEdge(9, 11, 7)
            .addEdge(10, 8, 1)
            .addEdge(11, 8, 9)
            .addEdge(12, 13, 5)
            .addEdge(13, 12, 12);
}
