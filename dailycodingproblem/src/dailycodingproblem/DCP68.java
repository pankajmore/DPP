package dailycodingproblem;

import java.util.HashMap;
import java.util.Map;

/**
 * This problem was asked by Google.
 *
 * <p>On our special chessboard, two bishops attack each other if they share the same diagonal. This
 * includes bishops that have another bishop located between them, i.e. bishops can attack through
 * pieces.
 *
 * <p>You are given N bishops, represented as (row, column) tuples on a M by M chessboard. Write a
 * function to count the number of pairs of bishops that attack each other. The ordering of the pair
 * doesn't matter: (1, 2) is considered the same as (2, 1).
 */
class DCP68 {
  static int numPairsAttacking(int[][] positions) {
    Map<Integer, Integer> posDiag = new HashMap<>();
    Map<Integer, Integer> negDiag = new HashMap<>();
    for (int[] pos : positions) {
      int posC = pos[1] - pos[0];
      int negC = pos[1] + pos[0];
      posDiag.put(posC, posDiag.getOrDefault(posC, 0) + 1);
      negDiag.put(negC, negDiag.getOrDefault(negC, 0) + 1);
    }
    int numPairs = 0;
    for (int num : posDiag.values()) {
      numPairs += num * (num - 1) / 2;
    }
    for (int num : negDiag.values()) {
      numPairs += num * (num - 1) / 2;
    }
    return numPairs;
  }
}
