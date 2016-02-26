/**
 * Created by pankaj on 2/22/16.
 */
public class Rank {

    /**
     * Given a string, find the rank of the string amongst its permutations sorted lexicographically.
     * Note that the characters might be repeated. If the characters are repeated, we need to look at the rank in unique permutations.
     * Look at the example for more details.
     * <p>
     * Example :
     * <p>
     * Input : 'aba'
     * Output : 2
     * <p>
     * The order permutations with letters 'a', 'a', and 'b' :
     * aab
     * aba
     * baa
     * The answer might not fit in an integer, so return your answer % 1000003
     *
     * @param s the input string
     * @return the rank of s
     */
    public static int rank(String s) {
        int N = s.length(), rank = 1;
        int[] charCount = new int[256];
        for (char c : s.toCharArray()) charCount[c]++;
        for (int i = 0; i < N - 1; i++) {
            char c = s.charAt(i);
            for (char j = 0; j < c; j++) {
                if (charCount[j] > 0) {
                    charCount[j]--;
                    rank += numPermutations(charCount, N - i - 1);
                    charCount[j]++;
                }
            }
            charCount[c]--;
        }
        return rank;
    }

    private static int numPermutations(int[] charCount, int num) {
        int f = fact(num);
        for (int i = 0; i < 256; i++) f /= fact(charCount[i]);
        return f;
    }

    private static int fact(int n) {
        int p = 1;
        for (int i = 1; i <= n; i++) p *= i;
        return p;
    }
}
