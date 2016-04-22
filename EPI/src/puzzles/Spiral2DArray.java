package puzzles;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.min;
import static java.lang.StrictMath.ceil;

/**
 * Created by pankajm on 6/2/15.
 */
public class Spiral2DArray {
    public static ArrayList<Integer> spiral(int[][] A) {
        if (A.length == 0 || A[0].length == 0) return new ArrayList<>();
        int M = A.length;
        int N = A[0].length;
        int i;
        ArrayList<Integer> S = new ArrayList<Integer>(M * N);
        for (i = 0; i <= min(ceil(M / 2), ceil(N / 2)); i++) {
            S.addAll(cycle(A, i));
        }
        return S;
    }

    public static ArrayList<Integer> spiral1(int[][] A) {
        if (A.length == 0 || A[0].length == 0) return new ArrayList<>();
        int M = A.length;
        int N = A[0].length;
        ArrayList<Integer> list = new ArrayList<>();
        int top = 0, bottom = M - 1, left = 0, right = N - 1;
        while (top <= bottom && left <= right) {
            for (int c = left; c <= right; c++) list.add(A[top][c]);
            top++;
            for (int r = top; r <= bottom; r++) list.add(A[r][right]);
            right--;
            if (top <= bottom) for (int c = right; c >= left; c--) list.add(A[bottom][c]);
            bottom--;
            if (left <= right) for (int r = bottom; r >= top; r--) list.add(A[r][left]);
            left++;
        }
        return list;
    }

    /**
     * Time : O(N^2)
     * Space: O(N^2)
     *
     * @param N > 0
     * @return a square matrix of size NxN with values [1,N^2] filled spirally
     */
    public static int[][] generateSpiralMatrix(int N) {
        int[][] A = new int[N][N];
        if (N == 0) return A;
        int v = 1;
        for (int x = 0; x <= N / 2; x++) {
            if (x == N - 1 - x) {
                A[x][x] = v++;
                break;
            }
            for (int i = x; i < N - 1 - x; i++) A[x][i] = v++;
            for (int i = x; i < N - 1 - x; i++) A[i][N - 1 - x] = v++;
            for (int i = N - 1 - x; i > x; i--) A[N - 1 - x][i] = v++;
            for (int i = N - 1 - x; i > x; i--) A[i][x] = v++;
        }
        return A;
    }

    /**
     * @param L a list of size N * N
     * @return a spiral square matrix with values filled from L
     */
    public static int[][] generateSpiralMatrix1(List<Integer> L) {
        int N = (int) Math.sqrt(L.size());
        if (N * N != L.size()) throw new IllegalArgumentException("list's length should be a perfect square!");
        int[][] A = new int[N][N];
        int idx = 0;
        for (int x = 0; x <= N / 2; x++) {
            if (x == N - 1 - x) {
                A[x][x] = L.get(idx++);
                break;
            }
            for (int i = x; i < N - 1 - x; i++) A[x][i] = L.get(idx++);
            for (int i = x; i < N - 1 - x; i++) A[i][N - 1 - x] = L.get(idx++);
            for (int i = N - 1 - x; i > x; i--) A[N - 1 - x][i] = L.get(idx++);
            for (int i = N - 1 - x; i > x; i--) A[i][x] = L.get(idx++);
        }
        return A;
    }

    private static ArrayList<Integer> cycle(int[][] A, int x) {
        int M = A.length;
        int N = A[0].length;
        ArrayList<Integer> l = new ArrayList<Integer>();
        if (x == N - 1 - x) {
            l.add(A[x][x]);
            return l;
        }
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
