/**
 * https://leetcode.com/problems/first-bad-version/
 * Created by pankaj on 17/02/17.
 */
public class FirstBadVersion {
    class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int lo = 1, hi = n;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (!isBadVersion(mid)) lo = mid + 1;
                else hi = mid;
            }
            return lo;
        }
    }

    class VersionControl {
        boolean isBadVersion(int version) {
            throw new UnsupportedOperationException();
        }
    }
}
