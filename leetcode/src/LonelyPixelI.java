/** https://leetcode.com/problems/lonely-pixel-i/ Created by pankaj on 05/03/17. */
public class LonelyPixelI {
  public int findLonelyPixel(char[][] picture) {
    if (picture.length == 0 || picture[0].length == 0) return 0;
    int M = picture.length, N = picture[0].length, cnt = 0;
    int[] row = new int[M], col = new int[N];
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (picture[i][j] == 'B') {
          row[i]++;
          col[j]++;
        }
      }
    }
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (picture[i][j] == 'B' && row[i] == 1 && col[j] == 1) cnt++;
      }
    }
    return cnt;
  }
}
