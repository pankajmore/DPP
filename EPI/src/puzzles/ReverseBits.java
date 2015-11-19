package puzzles;

/**
 * Created by Pankaj on 11/19/15.
 */
public class ReverseBits {
    public static int kWordSize = 16;
    public static int kBitMask = 0xFFFF;
    public static int[] cache = new int[2 << kWordSize];

    public static long reverse(long x) {
        return (cached(x & kBitMask) << (3 * kWordSize))
                | (cached((x >>> kWordSize) & kBitMask) << (2 * kWordSize))
                | (cached((x >>> (2 * kWordSize)) & kBitMask) << kWordSize)
                | cached((x >>> (3 * kWordSize)) & kBitMask);
    }

    public static long reverseA(long x) {
        return reverseImpl(x, Long.SIZE);
    }

    private static long reverseImpl(long x, int wordSize) {
        for (int i = 0; i < wordSize / 2; i++) x = swapBits(x, i, wordSize - 1 - i);
        return x;
    }

    private static long swapBits(long x, int i, int j) {
        if (((x >> i) & 1) != ((x >> j) & 1))
            x ^= 1L << i | 1L << j;
        return x;
    }

    private static long cached(long x) {
        int w = ((int) x);
        if (w == 0) return 0;
        if (cache[w] == 0) {
            cache[w] = (int) reverseImpl(x, kWordSize);
        }
        return cache[w];
    }
}
