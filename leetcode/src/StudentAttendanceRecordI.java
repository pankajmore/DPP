/**
 * Created by pankaj on 16/04/17.
 */
public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        int N = s.length(), cntA = 0, cntL = 0;
        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            if (c == 'L') cntL++;
            else cntL = 0;
            if (c == 'A') cntA++;
            if (cntA > 1 || cntL > 2) return false;
        }
        return true;
    }
}
