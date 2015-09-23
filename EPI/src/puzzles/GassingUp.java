package puzzles;

/**
 * Created by Pankaj on 9/23/15.
 */
public class GassingUp {
    private final int[] capacity;
    private final int[] distance;
    private final int N;

    public GassingUp(int[] capacity, int[] distance) {
        this.capacity = capacity;
        this.distance = distance;
        this.N = capacity.length;
    }

    public int ampleCity() {
        if (this.N == 0) return -1;
        int sum = 0, csum = 0, flag = 0;
        for (int i = 0; i < this.N; i++) {
            sum += val(i);
            if (val(i) < 0) flag = 1;
        }
        if (sum < 0) return -1;
        if (flag == 0) return 0;
        int start = 0, stop = 0;
        while (val(stop) >= 0) {
            start++;
            stop++;
        }
        assert val(stop) < 0;
        csum = val(stop);
        while (csum < 0) {
            start = decr(start);
            csum += val(start);
        }
        assert start != stop;
        while (start != stop) {
            stop = incr(stop);
            csum += val(stop);
            while (csum < 0) {
                start = decr(start);
                csum += val(start);
                assert start != stop;
            }
        }
        return start;
    }

    private int decr(int i) {
        return (i - 1) < 0 ? this.N + (i - 1) % this.N : (i - 1) % this.N;
    }

    private int incr(int i) {
        return (i + 1) % this.N;
    }

    private int val(int i) {
        return capacity[i] - distance[i];
    }

    public boolean check(int start) {
        int stop = start;
        int csum = 0;
        do {
            csum += val(start);
            start = incr(start);
            if (csum < 0) return false;
        }
        while (start != stop);
        return csum >= 0;
    }
}
