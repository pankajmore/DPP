package dailycodingproblem;

/**
 * There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given
 * N, write a function that returns the number of unique ways you can climb the staircase. The order
 * of the steps matters.
 * <p>
 * <p>For example, if N is 4, then there are 5 unique ways:
 * <p>
 * <p>What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number
 * from a set of positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5
 * steps at a time.
 */
class DCP12 {
    static int numWays(int[] steps, int numStairs) {
        int[] numWays = new int[numStairs + 1];
        numWays[0] = 1;
        for (int i = 1; i <= numStairs; i++) {
            for (int step : steps) {
                if (step <= i) {
                    numWays[i] += numWays[i - step];
                }
            }
        }
        return numWays[numStairs];
    }
}
