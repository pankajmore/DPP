/** https://leetcode.com/problems/add-digits/ Created by pankaj on 09/12/16. */
class AddDigits {
  int addDigits(int num) {
    return num == 0 ? 0 : 1 + (num - 1) % 9;
  }
}
