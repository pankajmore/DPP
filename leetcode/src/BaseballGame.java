import java.util.Stack;

/** https://leetcode.com/problems/baseball-game/ */
class BaseballGame {
  int calPoints(String[] ops) {
    int sum = 0;
    Stack<Integer> scores = new Stack<>();
    for (String op : ops) {
      if (op.equals("+")) {
        int a = scores.pop();
        int b = scores.peek();
        scores.push(a);
        sum += a + b;
        scores.push(a + b);
      } else if (op.equals("C")) {
        sum -= scores.pop();
      } else if (op.equals("D")) {
        sum += scores.peek() * 2;
        scores.push(scores.peek() * 2);
      } else {
        int score = Integer.parseInt(op);
        scores.push(score);
        sum += score;
      }
    }
    return sum;
  }
}
