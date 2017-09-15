import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/moving-average-from-data-stream
 * Created by pankaj on 28/07/17.
 */
class MovingAverage {
  private Deque<Integer> queue;
  private int size;
  private double sum;

  MovingAverage(final int n) {
    this.size = n;
    sum = 0.0;
    queue = new ArrayDeque<>();
  }

  double next(final int val) {
    if (queue.size() == size) {
      sum -= queue.remove();
    }
    queue.add(val);
    sum += val;
    return sum / queue.size();
  }
}
