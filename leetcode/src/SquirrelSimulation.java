/** https://leetcode.com/problems/squirrel-simulation/ Created by pankaj on 07/05/17. */
class SquirrelSimulation {
  int minDistance(
      final int height,
      final int width,
      final int[] tree,
      final int[] squirrel,
      final int[][] nuts) {
    int sum = 0, min = Integer.MAX_VALUE;
    for (int[] nut : nuts) {
      int d = Math.abs(nut[0] - tree[0]) + Math.abs(nut[1] - tree[1]);
      sum += 2 * d;
      int curr = Math.abs(nut[0] - squirrel[0]) + Math.abs(nut[1] - squirrel[1]);
      if (curr - d < min) {
        min = curr - d;
      }
    }
    return sum + min;
  }
}
