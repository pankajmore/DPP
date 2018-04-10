/** https://leetcode.com/problems/add-digits/ Created by pankaj on 09/12/16. */
public class AddDigits {
  public int addDigits(int num) {
    return num == 0 ? 0 : 1 + (num - 1) % 9;
  }
}
