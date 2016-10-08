import java.util.Arrays;
import java.util.Scanner;

/**
 * http://www.spoj.com/problems/ALTSEQ/
 * Created by pankaj on 10/8/16.
 */
public class ALTSEQ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) A[i] = in.nextInt();
        int[] dp = new int[N];
        int max = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (Math.abs(A[i]) > Math.abs(A[j]) && Integer.signum(A[i]) * Integer.signum(A[j]) == -1)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
