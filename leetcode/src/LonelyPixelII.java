import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** https://leetcode.com/problems/lonely-pixel-ii/ Created by pankaj on 06/03/17. */
public class LonelyPixelII {
  public int findBlackPixel(char[][] picture, int K) {
    int M = picture.length, N = picture[0].length;
    int[] row = new int[M], col = new int[N];
    String[] hash = new String[M];
    Map<String, Set<Integer>> map = new HashMap<>();
    for (int i = 0; i < M; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < N; j++) {
        sb.append(picture[i][j]);
        if (picture[i][j] == 'B') {
          row[i]++;
          col[j]++;
        }
      }
      String h = sb.toString();
      hash[i] = h;
      map.computeIfAbsent(h, k -> new HashSet<>()).add(i);
    }
    int cnt = 0;
    for (int j = 0; j < N; j++) {
      boolean flag = false;
      int first = -1;
      for (int i = 0; i < M; i++) {
        if (picture[i][j] == 'B') {
          if (first == -1) {
            first = i;
            flag = true;
          } else {
            flag &= map.get(hash[i]).contains(first);
          }
          flag &= row[i] == K;
          flag &= col[j] == K;
        }
      }
      cnt += flag ? K : 0;
    }
    return cnt;
  }
}
