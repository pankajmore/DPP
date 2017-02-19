/**
 * https://leetcode.com/contest/leetcode-weekly-contest-20/problems/detect-capital/
 * Created by pankaj on 19/02/17.
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }
}