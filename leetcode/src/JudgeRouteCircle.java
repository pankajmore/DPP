/** https://leetcode.com/problems/judge-route-circle Created by pankaj on 16/08/17. */
class JudgeRouteCircle {
  boolean judgeCircle(final String moves) {
    int x = 0;
    int y = 0;
    for (int i = 0; i < moves.length(); i++) {
      char c = moves.charAt(i);
      if (c == 'R') {
        x++;
      } else if (c == 'L') {
        x--;
      } else if (c == 'U') {
        y++;
      } else {
        y--;
      }
    }
    return x == 0 && y == 0;
  }
}
