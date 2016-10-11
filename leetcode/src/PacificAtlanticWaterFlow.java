import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 * Created by pankaj on 10/10/16.
 */
public class PacificAtlanticWaterFlow {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
        int M = matrix.length, N = matrix[0].length;
        Cell pacific = new Cell(-1, -1), atlantic = new Cell(-2, -2);
        Map<Cell, List<Cell>> adj = new HashMap<>();
        adj.put(pacific, new ArrayList<>());
        adj.put(atlantic, new ArrayList<>());
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                Cell p = new Cell(i, j);
                if (i == 0 || j == 0) adj.get(pacific).add(p);
                if (i == M - 1 || j == N - 1) adj.get(atlantic).add(p);
                for (Cell n : p.neighbours(matrix)) {
                    adj.putIfAbsent(n, new ArrayList<>());
                    adj.get(n).add(p);
                }
            }
        }

        Set<Cell> pacificSet = bfs(adj, pacific);
        Set<Cell> atlanticSet = bfs(adj, atlantic);
        return pacificSet.stream().filter(atlanticSet::contains).map(Cell::toArray).collect(Collectors.toList());
    }

    private Set<Cell> bfs(Map<Cell, List<Cell>> adj, Cell begin) {
        Set<Cell> visited = new HashSet<>();
        Deque<Cell> q = new LinkedList<>();
        q.add(begin);
        while (!q.isEmpty()) {
            Cell u = q.remove();
            adj.putIfAbsent(u, new ArrayList<>());
            adj.get(u).stream().filter(v -> !visited.contains(v)).forEach(v -> {
                visited.add(v);
                q.add(v);
            });
        }
        return visited;
    }

    private static class Cell {
        final int x, y;

        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        List<Cell> neighbours(int[][] matrix) {
            List<Cell> ls = new ArrayList<>();
            int M = matrix.length, N = matrix[0].length;
            if (x - 1 >= 0 && matrix[x - 1][y] <= matrix[x][y]) ls.add(new Cell(x - 1, y));
            if (x + 1 < M && matrix[x + 1][y] <= matrix[x][y]) ls.add(new Cell(x + 1, y));
            if (y - 1 >= 0 && matrix[x][y - 1] <= matrix[x][y]) ls.add(new Cell(x, y - 1));
            if (y + 1 < N && matrix[x][y + 1] <= matrix[x][y]) ls.add(new Cell(x, y + 1));
            return ls;
        }

        int[] toArray() {
            return new int[]{this.x, this.y};
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || !(o instanceof Cell)) return false;
            Cell p = (Cell) o;
            return this.x == p.x && this.y == p.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.x, this.y);
        }
    }
}
