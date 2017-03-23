package puzzles;

/** Created by pankaj on 4/22/16. */
public class SwapEvenOddBits {
  public static int swapEvenOddBits(int x) {
    return (x & 0xAAAAAAAA) >>> 1 | (x & 0x55555555) << 1;
  }

  public static int swapEvenOddBits1(int n) {
    for (int i = 0; i < Integer.SIZE; i += 2)
      if ((n >> i & 1) != ((n >> i + 1) & 1)) n ^= 0b11 << i;
    return n;
  }
}
