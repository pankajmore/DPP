import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lonely-pixel-ii/ Created by pankaj on 06/03/17.
 */
public class LonelyPixelII {
    public int findBlackPixel(char[][] picture, int K) {
        int M = picture.length, N = picture[0].length, cnt = 0;
        int[] col = new int[N];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            int row = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++) {
                sb.append(picture[i][j]);
                if (picture[i][j] == 'B') {
                    row++;
                    col[j]++;
                }
            }
            String h = sb.toString().intern();
            if (row == K) {
                map.put(h, map.getOrDefault(h, 0) + 1);
            }
        }
        for (String h : map.keySet()) {
            if (map.get(h) == K) {
                for (int j = 0; j < N; j++) {
                    if (h.charAt(j) == 'B' && col[j] == K) cnt += K;
                }
            }
        }
        return cnt;
    }
}
