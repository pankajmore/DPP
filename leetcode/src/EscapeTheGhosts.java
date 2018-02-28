/** https://leetcode.com/problems/escape-the-ghosts/description/ */
class EscapeTheGhosts {
  boolean escapeGhosts(int[][] ghosts, int[] target) {
    int td = Math.abs(target[0]) + Math.abs(target[1]);
    for (int[] ghost : ghosts) {
      int d = Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]);
      if (d <= td) {
        return false;
      }
    }
    return true;
  }
}
