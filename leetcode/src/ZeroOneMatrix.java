import java.util.List;

/** https://leetcode.com/problems/01-matrix/ Created by pankaj on 25/03/17. */
public class ZeroOneMatrix {
  public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
    if (matrix.size() == 0 || matrix.get(0).size() == 0) return matrix;
    int M = matrix.size(), N = matrix.get(0).size();
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (matrix.get(i).get(j) != 0) matrix.get(i).set(j, M + N);
      }
    }
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        int v =
            Math.min(
                matrix.get(i).get(j),
                Math.min(
                        i == 0 ? M + N : matrix.get(i - 1).get(j),
                        j == 0 ? M + N : matrix.get(i).get(j - 1))
                    + 1);
        matrix.get(i).set(j, v);
      }
    }
    for (int i = M - 1; i >= 0; i--) {
      for (int j = N - 1; j >= 0; j--) {
        int v =
            Math.min(
                matrix.get(i).get(j),
                Math.min(
                        i == M - 1 ? M + N : matrix.get(i + 1).get(j),
                        j == N - 1 ? M + N : matrix.get(i).get(j + 1))
                    + 1);
        matrix.get(i).set(j, v);
      }
    }
    return matrix;
  }
}
