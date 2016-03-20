package puzzles;

import java.util.ArrayList;
import java.util.List;

import static puzzles.ValidPalindrome.isPalindrome;

/**
 * Created by pankaj on 1/31/16.
 */
public class PalindromicPartitioning {
    /**
     * Time : O(N * 2 ^ (N - 1))
     * Space: O(N * 2 ^ (N - 1))
     *
     * @param s input string of size N
     * @return all possible palindromic decompositions of s
     */
    public static List<List<String>> palindromePartitioning(String s) {
        List<List<String>> list = new ArrayList<>();
        List<String> partialPartition = new ArrayList<>();
        palindromePartitioningHelper(list, partialPartition, s, 0);
        return list;
    }

    private static void palindromePartitioningHelper(List<List<String>> list, List<String> partialPartition, String s, int offset) {
        if (offset == s.length()) list.add(new ArrayList<>(partialPartition));
        else {
            for (int i = offset + 1; i <= s.length(); i++) {
                String prefix = s.substring(offset, i);
                if (isPalindrome(prefix)) {
                    partialPartition.add(prefix);
                    palindromePartitioningHelper(list, partialPartition, s, i);
                    partialPartition.remove(partialPartition.size() - 1);
                }
            }
        }
    }

    /**
     * Time : O(n^2)
     * Space : O(n^2)
     *
     * @param s a string of length n
     * @return the minimum number cuts needed in s to make each partition a palindrome
     */
    public static int minCuts(String s) {
        int n = s.length();
        boolean[][] isPalindrome = getPalindromeMatrix(s);
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (isPalindrome[j][i]) {
                    dp[i] = (j == 0 ? -1 : dp[j - 1]) + 1;
                    break;
                }
            }
        }
        return dp[n - 1];
    }

    /**
     * Time : O(n^2)
     * Space : O(n^2)
     *
     * @param s a string of length n
     * @return the palindromic decomposition of s whose length is minimum
     */
    public static List<String> minimumPalindromicDecompositions(String s) {
        int n = s.length();
        boolean[][] isPalindrome = getPalindromeMatrix(s);
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (isPalindrome[j][i]) {
                    dp[i] = (j == 0 ? 0 : dp[j - 1]) + 1;
                    break;
                }
            }
        }
        List<String> partitions = new ArrayList<>();
        int start = 0, end;
        for (int i = 1; i <= dp[n - 1]; i++) {
            assert dp[start] == i;
            for (end = n - 1; end >= start && dp[end] != dp[start]; end--) ;
            partitions.add(s.substring(start, end + 1));
            start = end + 1;
        }
        return partitions;
    }

    private static boolean[][] getPalindromeMatrix(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
            for (int j = i - 1, k = i + 1; j >= 0 && k < n && s.charAt(j) == s.charAt(k); j--, k++)
                isPalindrome[j][k] = true;
            for (int j = i, k = i + 1; j >= 0 && k < n && s.charAt(j) == s.charAt(k); j--, k++)
                isPalindrome[j][k] = true;
        }
        return isPalindrome;
    }
}
