import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** https://leetcode.com/problems/01-matrix/ Created by pankaj on 25/03/17. */
public class ZeroOneMatrix {
  public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
    if (matrix.size() == 0 || matrix.get(0).size() == 0) return matrix;
    int M = matrix.size(), N = matrix.get(0).size();
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (matrix.get(i).get(j) != 0) {
          matrix.get(i).set(j, bfs(i, j, matrix));
        }
      }
    }
    return matrix;
  }

  private int bfs(int i, int j, List<List<Integer>> matrix) {
    int l = 1;
    int M = matrix.size(), N = matrix.get(0).size();
    boolean[][] visited = new boolean[M][N];
    int[][] dir = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    Queue<int[]> q = new LinkedList<>();
    int[] s = new int[] {i, j};
    q.add(s);
    q.add(null);
    visited[i][j] = true;
    while (!q.isEmpty()) {
      int[] u = q.remove();
      if (u == null) {
        l++;
        q.add(null);
        continue;
      }
      for (int[] d : dir) {
        int[] v = new int[] {u[0] + d[0], u[1] + d[1]};
        if (v[0] >= 0 && v[0] < M && v[1] >= 0 && v[1] < N && !visited[v[0]][v[1]]) {
          if (matrix.get(v[0]).get(v[1]) == 0) return l;
          visited[v[0]][v[1]] = true;
          q.add(v);
        }
      }
    }
    return -1;
  }
}
