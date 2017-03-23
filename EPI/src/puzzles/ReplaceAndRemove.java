package puzzles;

import java.io.PrintStream;
import java.util.Scanner;

import static java.lang.Math.max;

/** Created by Pankaj on 6/5/15. */
public class ReplaceAndRemove {
  public static void replaceAndRemove(char[] s) {
    remove(s, 'b');
    replace(s, 'a', "dd");
  }

  private static void replace(char[] s, char c, String t) {
    int N = s.length;
    if (count(s) == 0) return;
    int i = N - 1, j = last(s);
    char d = t.charAt(0);
    while (j >= 0) {
      if (s[j] == c) {
        j--;
        for (int k = 0; k < t.length(); k++) {
          s[i--] = d;
        }
      } else {
        s[i--] = s[j--];
      }
    }
    while (i >= 0) s[i--] = '\0';
    shiftLeft(s);
  }

  private static int last(char[] s) {
    for (int i = s.length - 1; i >= 0; i--) if (s[i] != '\0') return i;
    return 0;
  }

  private static int count(char[] s) {
    int c = 0;
    for (char value : s) if (value != '\0') c++;
    return c;
  }

  private static void shiftLeft(char[] s) {
    int i = 0, j = 0;
    while (s[j] == '\0') j++;
    while (j < s.length) {
      s[i++] = s[j++];
    }
    while (i < s.length) s[i++] = '\0';
  }

  private static void remove(char[] s, char c) {
    int i = 0, j = 0;
    while (s[j] != '\0') {
      if (s[j] == c) j++;
      else {
        s[i++] = s[j++];
      }
    }
    while (i < s.length) s[i++] = '\0';
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintStream out = new PrintStream(System.out);
    String s = in.nextLine();
    char[] ss = allocate(s);
    replaceAndRemove(ss);
    out.println(ss);
  }

  private static char[] allocate(String s) {
    int as = 0, bs = 0, N = s.length();
    for (char c : s.toCharArray()) {
      if (c == 'a') as++;
      if (c == 'b') bs++;
    }
    char[] ss = new char[max(N + 1, N - bs + as + 1)];
    for (int i = 0; i < N; i++) {
      ss[i] = s.charAt(i);
    }
    ss[N] = '\0';
    return ss;
  }
}
