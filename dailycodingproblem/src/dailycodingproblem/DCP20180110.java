package dailycodingproblem;

/**
 * Given an array of integers, find the first missing positive integer in linear time and constant
 * space. In other words, find the lowest positive integer that does not exist in the array. The
 * array can contain duplicates and negative numbers as well. For example, the input [3, 4, -1, 1]
 * should give 2. The input [1, 2, 0] should give 3. You can modify the input array in-place.
 */
class DCP20180110 {
    static int firstMissingPositiveInteger(int[] in) {
        for (int i = 0; i < in.length; i++) {
            while (in[i] > 0 && in[i] <= in.length && in[i] != i + 1) {
                int tmp = in[in[i] - 1];
                in[in[i] - 1] = in[i];
                in[i] = tmp;
            }
        }
        for (int i = 0; i < in.length; i++) {
            if (in[i] != i + 1) {
                return i + 1;
            }
        }
        return in.length + 1;
    }
}
