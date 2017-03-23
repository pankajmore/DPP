package puzzles;

import java.util.ArrayList;
import java.util.List;

/** Created by pankaj on 2/11/16. */
public class ValidIPAddress {
  public static List<String> getValidIpAddress(String s) {
    List<String> l = new ArrayList<>();
    int N = s.length();
    if (N > 12) return l;
    for (int i = 0; i < N; i++)
      for (int j = i + 1; j < N; j++)
        for (int k = j + 1; k < N; k++) if (isValid(s, i, j, k)) l.add(getIP(s, i, j, k));
    return l;
  }

  private static String getIP(String s, int i, int j, int k) {
    int N = s.length();
    String
        a = s.substring(0, i),
        b = s.substring(i, j),
        c = s.substring(j, k),
        d = s.substring(k, N);
    return a + "." + b + "." + c + "." + d;
  }

  private static boolean octet(String s) {
    return !s.isEmpty() && !(s.charAt(0) == '0' && s.length() > 1) && Long.parseLong(s) < 256L;
  }

  private static boolean isValid(String s, int i, int j, int k) {
    int N = s.length();
    String
        a = s.substring(0, i),
        b = s.substring(i, j),
        c = s.substring(j, k),
        d = s.substring(k, N);
    return octet(a) && octet(b) && octet(c) && octet(d);
  }
}
