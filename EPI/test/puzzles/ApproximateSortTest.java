package puzzles;

import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class ApproximateSortTest {

    @Test
    public void bookExample() throws Exception {
        int[] A = new int[]{2, 1, 5, 4, 3, 9, 8, 7, 6};
        A = ApproximateSort.sortApproximatelySortedData(A, 3);
        for (int i = 1; i < A.length; i++) assert A[i - 1] <= A[i];
    }
}