package dailycodingproblem;

import java.util.Random;

public class DCP71 {
  Random rng = new Random();

  int rand5() {
    int x;
    while ((x = 7 * rand7() + rand7() - 7) > 45) {}
    return 1 + (x - 1) % 5;
  }

  int rand7() {
    return 1 + rng.nextInt(7);
  }
}
