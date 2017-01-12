/**
 * https://leetcode.com/problems/bulls-and-cows/
 * Created by pankaj on 12/01/17.
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int[] cntSecret = new int[10], cntGuess = new int[10];
        int bulls = 0, cows = 0;
        int N = secret.length();
        for (int i = 0; i < N; i++) {
            int x = secret.charAt(i) - '0';
            int y = guess.charAt(i) - '0';
            if (x == y) bulls++;
            else {
                cntSecret[x]++;
                cntGuess[y]++;
            }
        }
        for (int i = 0; i < 10; i++) {
            cows += Math.min(cntSecret[i], cntGuess[i]);
        }
        return bulls + "A" + cows + "B";
    }
}
