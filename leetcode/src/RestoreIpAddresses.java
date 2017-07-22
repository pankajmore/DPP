import java.util.ArrayList;
import java.util.List;

/** https://leetcode.com/problems/restore-ip-addresses/ Created by pankaj on 22/07/17. */
class RestoreIpAddresses {
  List<String> restoreIpAddresses(final String s) {
    List<String> ipAddresses = new ArrayList<>();
    int n = s.length();
    if (n > 16) {
      return ipAddresses;
    }
    for (int i = 0; i < n - 3; i++) {
      String a = s.substring(0, i + 1);
      if (isValid(a)) {
        for (int j = i + 1; j < n - 2; j++) {
          String b = s.substring(i + 1, j + 1);
          if (isValid(b)) {
            for (int k = j + 1; k < n - 1; k++) {
              String c = s.substring(j + 1, k + 1);
              String d = s.substring(k + 1, n);
              if (isValid(c) && isValid(d)) {
                ipAddresses.add(String.format("%s.%s.%s.%s", a, b, c, d));
              }
            }
          }
        }
      }
    }
    return ipAddresses;
  }

  private boolean isValid(final String s) {
    if (s.length() > 3) {
      return false;
    }
    if (s.startsWith("0") && s.length() > 1) {
      return false;
    }
    long v = Long.parseLong(s);
    return v >= 0 && v <= 255;
  }
}
