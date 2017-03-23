package puzzles;

/** Created by Pankaj on 9/27/15. */
public class SpreadsheetEncoding {
  public static int ssDecodeColID(final String col) {
    int ret = 0;
    for (char c : col.toCharArray()) ret = ret * 26 + c - 'A' + 1;
    return ret;
  }
}
