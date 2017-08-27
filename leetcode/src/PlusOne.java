/** https://leetcode.com/problems/plus-one/ Created by pankaj on 26/12/16. */
class PlusOne {
  int[] plusOne(final int[] digits) {
    int len = digits.length;
    for (int i = len - 1; i >= 0; i--) {
      if (digits[i] < 9) {
        digits[i]++;
        return digits;
      } else {
        digits[i] = 0;
      }
    }
    int[] newNumber = new int[len + 1];
    newNumber[0] = 1;
    return newNumber;
  }
}
