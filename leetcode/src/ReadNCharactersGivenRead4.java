interface Read4 {
  int read4(char[] buf);
}

/** https://leetcode.com/problems/read-n-characters-given-read4 Created by pankaj on 02/08/17. */
abstract class ReadNCharactersGivenRead4 implements Read4 {
  int read(final char[] buf, final int n) {
    boolean eof = false;
    int total = 0;
    char[] tmp = new char[4];
    while (!eof && total < n) {
      int count = read4(tmp);
      eof = count < 4;
      count = Math.min(count, n - total);
      for (int i = 0; i < count; i++) {
        buf[total++] = tmp[i];
      }
    }
    return total;
  }
}
