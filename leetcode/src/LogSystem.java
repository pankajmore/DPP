import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** https://leetcode.com/problems/design-log-storage-system/ Created by pankaj on 03/07/17. */
class LogSystem {
  private Map<Integer, Timestamp> timestamps;

  LogSystem() {
    timestamps = new HashMap<>();
  }

  void put(final int id, final String timestamp) {
    timestamps.put(id, new Timestamp(timestamp));
  }

  List<Integer> retrieve(final String s, final String e, final String gra) {
    List<Integer> ls = new ArrayList<>();
    Timestamp ts = new Timestamp(s);
    Timestamp te = new Timestamp(e);
    for (Map.Entry<Integer, Timestamp> entry : timestamps.entrySet()) {
      int id = entry.getKey();
      Timestamp t = entry.getValue();
      if (t.inRange(ts, te, gra)) {
        ls.add(id);
      }
    }
    return ls;
  }

  class Timestamp {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;

    Timestamp(String s) {
      String[] xs = s.split(":");
      year = Integer.parseInt(xs[0]);
      month = Integer.parseInt(xs[1]);
      day = Integer.parseInt(xs[2]);
      hour = Integer.parseInt(xs[3]);
      minute = Integer.parseInt(xs[4]);
      second = Integer.parseInt(xs[5]);
      year -= 2000;
      month += year * 12;
      day += month * 30;
      hour += day * 24;
      minute += hour * 60;
      second += minute * 60;
    }

    @Override
    public String toString() {
      return String.format("%d:%d:%d:%d:%d:%d", year, month, day, hour, minute, second);
    }

    boolean inRange(final Timestamp s, final Timestamp e, final String gra) {
      if (year < s.year || year > e.year) {
        return false;
      }
      if (gra.equals("Year")) {
        return true;
      }
      if (month < s.month || month > e.month) {
        return false;
      }
      if (gra.equals("Month")) {
        return true;
      }
      if (day < s.day || day > e.day) {
        return false;
      }
      if (gra.equals("Day")) {
        return true;
      }
      if (hour < s.hour || hour > e.hour) {
        return false;
      }
      if (gra.equals("Hour")) {
        return true;
      }
      if (minute < s.minute || minute > e.minute) {
        return false;
      }
      if (gra.equals("Minute")) {
        return true;
      }
      if (second < s.second || second > e.second) {
        return false;
      }
      return true;
    }
  }
}
