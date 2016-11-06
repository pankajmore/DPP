import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/contest/12/problems/minimum-number-of-arrows-to-burst-balloons/
 * Created by pankaj on 11/6/16.
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        List<Interval> A = new ArrayList<>();
        for (int[] p : points) A.add(new Interval(p[0], p[1]));
        Collections.sort(A, (x, y) -> x.end != y.end ? Integer.compare(x.end, y.end) : Integer.compare(x.start, y.start));
        int cnt = 1;
        Interval prev = A.get(0);
        Interval curr;
        for (int i = 1; i < A.size(); i++) {
            curr = A.get(i);
            if (curr.start > prev.end) {
                cnt++;
                prev = curr;
            }
        }
        return cnt;
    }

    private static class Interval {
        int start, end;

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
