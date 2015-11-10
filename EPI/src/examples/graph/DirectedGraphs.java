package examples.graph;

import utils.graph.DirectedGraph;

/**
 * Created by Pankaj on 11/10/15.
 */
public class DirectedGraphs {
    public static DirectedGraph twoNodeCycle = new DirectedGraph(2).addEdge(0, 1).addEdge(1, 0);
    public static DirectedGraph diamond = new DirectedGraph(4).addEdge(0, 1).addEdge(0, 2).addEdge(1, 3).addEdge(2, 3);
}
