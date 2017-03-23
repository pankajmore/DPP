package puzzles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Created by Pankaj on 10/20/15. */
public class RenderingCalendar {
  public static int findMaxOverlappingIntervals(List<Interval> ls) {
    List<Endpoint> endpoints = new ArrayList<>();
    for (Interval i : ls) {
      endpoints.add(new Endpoint(i._start, true));
      endpoints.add(new Endpoint(i._end, false));
    }
    Collections.sort(endpoints);
    int count = 0, maxCount = 0;
    for (Endpoint endpoint : endpoints) {
      if (endpoint.isStart()) count++;
      else count--;
      maxCount = Math.max(maxCount, count);
    }
    return maxCount;
  }

  public static class Interval implements Comparable<Interval> {
    private final int _start;
    private final int _end;

    public Interval(int start, int end) {
      _start = start;
      _end = end;
    }

    public int start() {
      return _start;
    }

    public int end() {
      return _end;
    }

    @Override
    public int compareTo(Interval o) {
      return Integer.compare(this._start, o._start);
    }
  }

  private static class Endpoint implements Comparable<Endpoint> {
    private final int _point;
    private final boolean _isStart;

    private Endpoint(int point, boolean start) {
      _point = point;
      _isStart = start;
    }

    @Override
    public int compareTo(Endpoint o) {
      if (this._point != o.point()) return Integer.compare(_point, o.point());
      return _isStart && !o._isStart ? -1 : !_isStart && o._isStart ? 1 : 0;
    }

    public int point() {
      return _point;
    }

    public boolean isStart() {
      return _isStart;
    }
  }
}
