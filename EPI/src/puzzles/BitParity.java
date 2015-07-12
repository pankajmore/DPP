package puzzles;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by pankajm on 5/4/15.
 */
public class BitParity {
    int B = 65536;
    int A[] = new int[B];

    public BitParity() {
        precompute();
    }

    public static void main(String[] args) {
        BitParity bp = new BitParity();
        Scanner in = new Scanner(System.in);
        PrintStream out = new PrintStream(System.out);
        while (in.hasNextLong()) {
            long l = in.nextLong();
            out.print("Parity of " + l + " : ");
            out.println((bp.parity(l)));
        }
    }

    public void precompute() {
        for (int i = 0; i < B; i++) {
            A[i] = parity(i);
        }
    }

    public int parity(int x) {
        int c = 0;
        while (x > 0) {
            x ^= x & ~(x - 1);
            c++;
        }
        return c & 1;
    }

    public int parity(long x) {
        int c = 0, B = Integer.parseInt("1111111111111111", 2);
        while (x > 0) {
            c += A[((int) (x & B))];
            x >>= 16;
        }
        return c & 1;
    }
}
