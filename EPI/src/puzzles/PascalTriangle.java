package puzzles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pankaj on 1/30/16.
 */
public class PascalTriangle {
    public static List<List<Integer>> pascalTriangle(int n) {
        List<List<Integer>> rows = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(1);
        rows.add(row);
        for (int i = 1; i < n; i++) {
            row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                row.add((j == 0 ? 0 : rows.get(i - 1).get(j - 1)) + (j == i ? 0 : rows.get(i - 1).get(j)));
            }
            rows.add(row);
        }
        return rows;
    }

    /**
     * Time : O(NxN)
     * Space: O(N)
     *
     * @param N positive integer
     * @return the Nth row of Pascal's Triangle
     */
    public static List<Integer> getNthRow(int N) {
        List<Integer> A = new ArrayList<>();
        if (N <= 0) return A;
        for (int i = 0; i < N; i++) A.add(0);
        A.set(0, 1);
        for (int i = 1; i < N; i++) {
            int temp = A.get(0);
            for (int j = 1; j < i; j++) {
                int next = A.get(j);
                A.set(j, temp + next);
                temp = next;
            }
            A.set(i, temp);
        }
        return A;
    }

    /**
     * Time : O(N)
     * Space: O(N)
     *
     * @param N positive integer
     * @return the Nth row of Pascal's Triangle
     */
    public static List<Integer> getNthRow1(int N) {
        List<Integer> A = new ArrayList<>();
        if (N <= 0) return A;
        int[] fact = new int[N];
        fact[0] = 1;
        for (int i = 1; i < N; i++) fact[i] = i * fact[i - 1];

        for (int i = 0; i < N; i++) {
            A.add(fact[N - 1] / (fact[i] * fact[N - 1 - i]));
        }
        return A;
    }
}
