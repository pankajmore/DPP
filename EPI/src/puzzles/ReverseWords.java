package puzzles;

/**
 * Created by Pankaj on 10/1/15.
 */
public class ReverseWords {
    static char[] reverseWords(char[] s) {
        int i = 0, j = 0, N = s.length;
        reverse(s, i, N - 1);
        while (j < N) {
            while (j < N && s[j] != ' ') j++;
            reverse(s, i, j - 1);
            i = ++j;
        }
        if (i < N && j == N) reverse(s, i, N - 1);
        return s;
    }

    private static void reverse(char[] A, int i, int j) {
        while (i < j) {
            char temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }
    }
}
