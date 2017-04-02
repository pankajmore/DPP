/** https://leetcode.com/problems/friend-circles/ Created by pankaj on 02/04/17. */
public class FriendCircles {
  public int findCircleNum(int[][] M) {
    int N = M.length, cnt = 0;
    boolean[] visited = new boolean[N];
    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        visit(i, M, visited);
        cnt++;
      }
    }
    return cnt;
  }

  private void visit(int u, int[][] M, boolean[] visited) {
    for (int v = 0; v < M.length; v++) {
      if (u != v && M[u][v] == 1 && !visited[v]) {
        visited[v] = true;
        visit(v, M, visited);
      }
    }
  }
}
