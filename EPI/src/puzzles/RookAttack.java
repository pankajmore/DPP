package puzzles;

import java.util.Collections;
import java.util.List;

/** Created by pankaj on 4/26/16. */
public class RookAttack {
  /**
   * Time : O(MxN) Space: O(1)
   *
   * <p>Mark all cells that can be attacked by any rook as 0
   */
  public static void rookAttack(List<List<Integer>> A) {
    if (A.size() == 0 || A.get(0).size() == 0) return;
    int M = A.size(), N = A.get(0).size();
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (A.get(i).get(j) == 0) A.get(i).set(j, 2);
      }
    }
    for (int i = 0; i < M; i++) {
      if (A.get(i).contains(2)) {
        for (int j = 0; j < N; j++) {
          if (A.get(i).get(j) != 2) A.get(i).set(j, 0);
        }
      }
    }
    for (int j = 0; j < N; j++) {
      boolean attack = false;
      for (int i = 0; i < M; i++) {
        if (A.get(i).get(j) == 2) {
          attack = true;
          break;
        }
      }
      if (attack) {
        for (int i = 0; i < M; i++) {
          if (A.get(i).get(j) != 2) A.get(i).set(j, 0);
        }
      }
    }
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (A.get(i).get(j) == 2) A.get(i).set(j, 0);
      }
    }
  }

  /**
   * Time : O(MxN) Space: O(1)
   *
   * <p>Mark all cells that can be attacked by any rook as 0
   *
   * @param A an MxN grid of rook positions denoted by 0
   */
  public static void rookAttack1(List<List<Integer>> A) {
    if (A.size() == 0 || A.get(0).size() == 0) return;
    int M = A.size(), N = A.get(0).size();
    boolean hasFirstRowZero = false, hasFirstColumnZero = false;
    for (int j = 0; j < N; j++) if (A.get(0).get(j) == 0) hasFirstRowZero = true;
    for (int i = 0; i < M; i++) if (A.get(i).get(0) == 0) hasFirstColumnZero = true;
    for (int i = 1; i < M; i++) {
      for (int j = 1; j < N; j++) {
        if (A.get(i).get(j) == 0) {
          A.get(i).set(0, 0);
          A.get(0).set(j, 0);
        }
      }
    }
    for (int i = 1; i < M; i++) if (A.get(i).get(0) == 0) Collections.fill(A.get(i), 0);
    for (int j = 1; j < N; j++)
      if (A.get(0).get(j) == 0) for (int i = 0; i < M; i++) A.get(i).set(j, 0);
    if (hasFirstRowZero) Collections.fill(A.get(0), 0);
    if (hasFirstColumnZero) for (int i = 0; i < N; i++) A.get(i).set(0, 0);
  }
}
