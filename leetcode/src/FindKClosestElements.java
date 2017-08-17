import java.util.List;

/** https://leetcode.com/problems/find-k-closest-elements/ Created by pankaj on 16/08/17. */
class FindKClosestElements {
  List<Integer> findClosestElements(final List<Integer> arr, final int k, final int x) {
    int start = greatestLessThanOrEqualTo(arr, x);
    int end = start;
    while (end - start + 1 < k) {
      if (start == 0) {
        end++;
      } else if (end == arr.size() - 1) {
        start--;
      } else if (arr.get(end + 1) - x < x - arr.get(start - 1)) {
        end++;
      } else {
        start--;
      }
    }
    return arr.subList(start, end + 1);
  }

  int greatestLessThanOrEqualTo(final List<Integer> arr, final int x) {
    int lo = 0;
    int hi = arr.size() - 1;
    int res = 0;
    while (lo <= hi) {
      int mid = (lo + hi) >>> 1;
      if (arr.get(mid) > x) {
        hi = mid - 1;
      } else {
        res = mid;
        lo = mid + 1;
      }
    }
    return res;
  }
}
