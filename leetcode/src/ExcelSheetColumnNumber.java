/** https://leetcode.com/problems/excel-sheet-column-number/ Created by pankaj on 14/12/16. */
class ExcelSheetColumnNumber {
  int titleToNumber(String s) {
    int x = 0;
    for (char c : s.toCharArray()) x = x * 26 + (c - 'A' + 1);
    return x;
  }
}
