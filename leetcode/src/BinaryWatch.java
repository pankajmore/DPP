import java.util.ArrayList;
import java.util.List;

/** https://leetcode.com/problems/binary-watch/ Created by pankaj on 9/23/16. */
public class BinaryWatch {
  public List<String> readBinaryWatch(int num) {
    List<String> l = new ArrayList<>();
    for (int h = 0; h < 12; h++) {
      for (int m = 0; m < 60; m++) {
        if (Integer.bitCount(h) + Integer.bitCount(m) == num) {
          l.add(String.format("%d:%02d", h, m));
        }
      }
    }
    return l;
  }
}
