package dailycodingproblem;

import java.util.Random;

class DCP71 {
  private static Random rng = new Random();

  static int rand5() {
    int x;
    while ((x = 7 * rand7() + rand7() - 7) > 45) {}
    return 1 + (x - 1) % 5;
  }

  static int rand7() {
    return 1 + rng.nextInt(7);
  }
}
