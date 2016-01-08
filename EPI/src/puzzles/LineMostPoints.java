package puzzles;

import java.util.*;

/**
 * Created by Pankaj on 1/8/16.
 */
public class LineMostPoints {
    /**
     * Time : O(n^2) assuming a good hash function
     * Space : O(n)
     *
     * @param points List of points in a 2D plane
     * @return the line passing through most points
     */
    public static Line getLineWithMostPoints(List<Point> points) {
        if (points.size() < 2) return null;
        Map<Line, Set<Point>> lineToPoints = new HashMap<>();
        Line bestLine = new Line(points.get(0), points.get(1));
        int maxPoints = 0;
        for (int i = 0; i < points.size(); i++) {
            Point p1 = points.get(i);
            for (int j = i + 1; j < points.size(); j++) {
                Point p2 = points.get(j);
                Line l = new Line(p1, p2);
                if (!lineToPoints.containsKey(l))
                    lineToPoints.put(l, new HashSet<>());
                lineToPoints.get(l).add(p1);
                lineToPoints.get(l).add(p2);
                int numPoints = lineToPoints.get(l).size();
                if (maxPoints < numPoints) {
                    maxPoints = numPoints;
                    bestLine = l;
                }
            }
        }
        return bestLine;
    }

    public static class Point {
        public final int x;
        public final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.x, this.y);
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point)) return false;
            Point p = (Point) o;
            return this.x == p.x && this.y == p.y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    public static class Line {
        public final double m;
        public final double c;

        public Line(double m, double c) {
            this.m = m;
            this.c = c;
        }

        public Line(Point a, Point b) {
            this.m = b.x != a.x ? (b.y - a.y) / (b.x - a.x) : Double.MAX_VALUE;
            this.c = b.x != a.x ? (b.x * a.y - a.x * b.y) / (b.x - a.x) : Double.MAX_VALUE;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Line)) return false;
            Line l = (Line) o;
            return this.m == l.m && this.c == l.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.m, this.c);
        }

        @Override
        public String toString() {
            if (this.m == Double.MAX_VALUE)
                return "x = " + c;
            if (this.m == 0)
                return "y = " + c;
            return "y = " + m + "x + " + c;
        }
    }
}
