import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by pankaj on 3/13/16.
 */
public class KnightOnChessBoard {
    public static int shortestPath(int M, int N, int x1, int y1, int x2, int y2) {
        int[][] dist = new int[M + 1][N + 1];
        if (x1 < 1 || x1 > M || y1 < 1 || y1 > N) return -1;
        Queue<Point> q = new LinkedList<>();
        for (int[] d : dist) Arrays.fill(d, -1);
        q.add(new Point(x1, y1));
        dist[x1][y1] = 0;
        while (!q.isEmpty()) {
            Point p = q.remove();
            if (p.x == x2 && p.y == y2) return dist[p.x][p.y];
            int[][] DIRS = new int[][]{{-2, -1}, {-2, 1}, {2, -1}, {2, 1},
                    {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};
            for (int[] d : DIRS) {
                int x = p.x + d[0], y = p.y + d[1];
                if (x > 0 && x <= M && y > 0 && y <= N && dist[x][y] == -1) {
                    dist[x][y] = dist[p.x][p.y] + 1;
                    q.add(new Point(x, y));
                }
            }
        }
        return -1;
    }

    private static class Point {
        final int x, y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
