package puzzles;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

/** Created by pankaj on 1/23/16. */
public class ArrayEndReachable {
  /**
   * Time : O(N) Space : O(1)
   *
   * @param A A[i] indicates how far can we jump from i
   * @return true if we can reach last index from start
   */
  public static boolean isArrayEndReachable(List<Integer> A) {
    int N = A.size();
    int lastReachableIndex = N - 1;
    for (int i = N - 2; i >= 0; i--) {
      if (lastReachableIndex - i <= A.get(i)) lastReachableIndex = i;
    }
    return lastReachableIndex == 0;
  }

  /**
   * Time : O(N) Space: O(1)
   *
   * @param A A_i indicates how far we can jump from i
   * @return true if we can reach the last index from start
   */
  public static boolean isArrayEndReachableGreedy(List<Integer> A) {
    int N = A.size(), furthest = 0;
    for (int i = 0; i <= furthest && furthest < N; i++) {
      furthest = Math.max(furthest, i + A.get(i));
    }
    return furthest >= N - 1;
  }

  /**
   * Time : O(N * N) Space: O(N)
   *
   * @param A A_i indicates how far we can jump from i
   * @return the minimum number of jumps needed from 0 to end if possible, otherwise -1
   */
  public static int minStepsToReachArrayEnd(@NotNull List<Integer> A) {
    int N = A.size();
    boolean[] reachable = new boolean[N];
    int[] steps = new int[N];
    Arrays.fill(steps, Integer.MAX_VALUE);
    reachable[N - 1] = true;
    steps[N - 1] = 0;
    for (int i = N - 2; i >= 0; i--) {
      for (int j = 1; j <= A.get(i) && i + j < N; i++) {
        if (reachable[i + j]) {
          steps[i] = Math.min(steps[i], steps[i + j] + 1);
        }
      }
    }
    return reachable[0] ? steps[0] : -1;
  }

  public static int minStepsToReachArrayEndGreedy(@NotNull List<Integer> A) {
    int N = A.size(), minSteps = 0, currentMaxJump = 0, lastMaxJump = 0;
    for (int i = 0; i < N - 1; i++) {
      currentMaxJump = Math.max(currentMaxJump, i + A.get(i));
      if (i == lastMaxJump) {
        minSteps++;
        lastMaxJump = currentMaxJump;
      }
      if (currentMaxJump == i) return -1;
    }
    return minSteps;
  }
}
