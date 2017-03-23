package utils.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Created by Pankaj on 11/6/15. */
public class DirectedGraph {
  private final int _numVertices;
  private final List<Set<Integer>> _adjacencyList;

  public DirectedGraph(int numVertices) {
    _numVertices = numVertices;
    _adjacencyList = new ArrayList<>();
    for (int i = 0; i < _numVertices; i++) _adjacencyList.add(new HashSet<>());
  }

  public DirectedGraph transpose() {
    DirectedGraph gt = new DirectedGraph(_numVertices);
    for (int u = 0; u < _numVertices; u++) for (Integer v : adj(u)) gt.addEdge(v, u);
    return gt;
  }

  public DirectedGraph addEdge(int u, int v) {
    _adjacencyList.get(u).add(v);
    return this;
  }

  public Set<Integer> adj(int u) {
    return _adjacencyList.get(u);
  }

  public int size() {
    return _numVertices;
  }
}
