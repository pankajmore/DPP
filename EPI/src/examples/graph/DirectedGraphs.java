package examples.graph;

import utils.graph.DirectedGraph;

/** Created by Pankaj on 11/10/15. */
public class DirectedGraphs {
  public static final DirectedGraph twoNodeCycle = new DirectedGraph(2).addEdge(0, 1).addEdge(1, 0);
  public static final DirectedGraph diamond =
      new DirectedGraph(4).addEdge(0, 1).addEdge(0, 2).addEdge(1, 3).addEdge(2, 3);
  public static final DirectedGraph wikiExample =
      new DirectedGraph(8)
          .addEdge(0, 1)
          .addEdge(1, 2)
          .addEdge(1, 4)
          .addEdge(1, 5)
          .addEdge(2, 3)
          .addEdge(2, 6)
          .addEdge(3, 2)
          .addEdge(3, 7)
          .addEdge(4, 0)
          .addEdge(4, 5)
          .addEdge(5, 6)
          .addEdge(6, 5)
          .addEdge(7, 3)
          .addEdge(7, 6);
}
