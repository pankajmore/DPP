import java.util.Arrays;
import java.util.Comparator;

/** https://leetcode.com/problems/meeting-rooms Created by pankaj on 31/07/17. */
class MeetingRooms {
  boolean canAttendMeetings(final Interval[] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(x -> x.start));
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i].start < intervals[i - 1].end) {
        return false;
      }
    }
    return true;
  }

  class Interval {
    private int start;
    private int end;
  }
}
