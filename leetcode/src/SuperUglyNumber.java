import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/super-ugly-number/
 * Created by pankaj on 15/02/17.
 */
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;
        int[] idx = new int[k];
        int[] nums = new int[n];
        nums[0] = 1;
        PriorityQueue<Pair> q = new PriorityQueue<>();
        for (int i = 0; i < k; i++) q.add(new Pair(1, i));
        int cnt = 0;
        for (int i = 1; !q.isEmpty() && i < n; ) {
            cnt++;
            Pair p = q.remove();
            int min = p.x, primeIdx = p.y, prime = primes[primeIdx];
            if (nums[i - 1] != min) nums[i++] = min;
            idx[primeIdx]++;
            int next = nums[idx[primeIdx] - 1];
            int nextUgly = next > Integer.MAX_VALUE / prime ? Integer.MAX_VALUE
                    : next < Integer.MIN_VALUE / prime ? Integer.MIN_VALUE : next * prime;
            q.add(new Pair(nextUgly, primeIdx));
        }
        System.out.println(cnt);
        return nums[n - 1];
    }

    class Pair implements Comparable<Pair> {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair p) {
            return Integer.compare(this.x, p.x);
        }
    }
}
