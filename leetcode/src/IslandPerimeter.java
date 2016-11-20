/**
 * https://leetcode.com/problems/island-perimeter/
 * Created by pankaj on 20/11/16.
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int p = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0) p += 1;
                    if (j == 0 || grid[i][j - 1] == 0) p += 1;
                    if (i == M - 1 || grid[i + 1][j] == 0) p += 1;
                    if (j == N - 1 || grid[i][j + 1] == 0) p += 1;
                }
            }
        }
        return p;
    }
}
