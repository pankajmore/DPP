package dailycodingproblem;

/**
 * You run a sneaker website and want to record the last N order ids in a log. Implement a data
 * structure to accomplish this, with the following API: record(order_id): adds the order_id to the
 * log get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or
 * equal to N. You should be as efficient with time and space as possible.
 */
class DCP16 {
    static class LastN {
        Integer[] elems;
        int idx;

        LastN(int n) {
            elems = new Integer[n];
            idx = -1;
        }

        void record(int e) {
            idx = (idx + 1) % elems.length;
            elems[idx] = e;
        }

        Integer getLast(int i) {
            int pos = idx - i;
            if (pos < 0) {
                pos = pos + elems.length;
            }
            return elems[pos];
        }
    }
}
