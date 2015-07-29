package puzzles;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static java.lang.Math.min;
import static java.lang.StrictMath.ceil;

/**
 * Created by pankajm on 6/2/15.
 */
public class Spiral2DArray {
    public static ArrayList<Integer> spiral(int[][] A) {
        int M = A.length;
        int N = A[0].length;
        int i;
        ArrayList<Integer> S = new ArrayList<Integer>(M * N);
        for (i = 0; i <= min(ceil(M / 2), ceil(N / 2)); i++) {
            S.addAll(cycle(A, i));
        }
        return S;
    }

    private static ArrayList<Integer> cycle(int[][] A, int x) {
        int M = A.length;
        int N = A[0].length;
        ArrayList<Integer> l = new ArrayList<Integer>();
        for (int i = x; i < N - 1 - x; i++)
            l.add(A[x][i]);
        for (int i = x; i < M - 1 - x; i++)
            l.add(A[i][N - 1 - x]);
        for (int i = N - 1 - x; i > x; i--)
            l.add(A[M - 1 - x][i]);
        for (int i = M - 1 - x; i > x; i--)
            l.add(A[i][x]);
        return l;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintStream out = new PrintStream(System.out);
        int M = in.nextInt();
        int N = in.nextInt();
        int[][] A = new int[M][N];
        ArrayList<Integer> F = new ArrayList<Integer>(M * N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++) {
                A[i][j] = in.nextInt();
                F.add(A[i][j]);
            }
        ArrayList<Integer> spiral = spiral(A);
        assert (spiral.size() == M * N);

        for (Integer i : spiral) {
            out.print(i + " ");
        }
        out.println();
        Collections.sort(spiral);
        Collections.sort(F);
        assert (spiral.equals(F));

    }
}
