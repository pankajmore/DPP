package puzzles;

import java.util.Random;

/** Created by pankaj on 3/30/16. */
public class UniformRandomNumberGeneration {
  /** @return 0 / 1 with equal probability */
  private static int uniformRandomZeroOne() {
    return new Random().nextInt(2);
  }

  /**
   * Time : O(1) Space: O(1) avg
   *
   * @param lowerBound non-negative inclusive
   * @param upperBound non-negative exclusive
   * @return a uniform random integer in [lowerBound, upperBound)
   */
  public static int uniformRandom(int lowerBound, int upperBound) throws Exception {
    if (lowerBound == upperBound) throw new IllegalArgumentException("Range cannot be empty!");
    return lowerBound + uniformRandom(upperBound - lowerBound);
  }

  /**
   * Time : O(1) Space: O(1) avg
   *
   * @param N positive, exclusive
   * @return a uniform random integer in [0, N)
   */
  public static int uniformRandom(int N) {
    if (N <= 0) throw new IllegalArgumentException("Range cannot be negative or zero : " + N);
    if (N > 1 << 30)
      throw new IllegalArgumentException(
          String.format("Range cannot be greater than %d : %d", 1 << 30, N));
    int x, c = 0;
    do {
      x = 0;
      for (int i = 0; (1 << i) < N; i++) x = (x << 1) | uniformRandomZeroOne();
      c++;
    } while (x >= N);
    System.out.println("Trails : " + c);
    return x;
  }
}
