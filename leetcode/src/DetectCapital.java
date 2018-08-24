/** https://leetcode.com/contest/leetcode-weekly-contest-20/problems/detect-capital/ */
class DetectCapital {
  boolean detectCapitalUse(String word) {
    return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
  }
}
