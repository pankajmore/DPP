package dp;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.generator.InRange;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;

/**
 * Created by pankaj on 29/11/16.
 */
@RunWith(Theories.class)
public class Q18Test {
    @Test
    public void largestSquare() throws Exception {
        assertEquals(0, Q18.largestSquare(emptyList()));
        assertEquals(0, Q18.largestSquare(singletonList(emptyList())));
        assertEquals(0, Q18.largestSquare(singletonList(singletonList(0))));
        assertEquals(1, Q18.largestSquare(singletonList(singletonList(1))));
        assertEquals(1, Q18.largestSquare(singletonList(asList(1, 1))));
        assertEquals(1, Q18.largestSquare(asList(asList(0, 1), asList(0, 1))));
        assertEquals(1, Q18.largestSquare(asList(asList(1, 1), asList(0, 1))));
        assertEquals(1, Q18.largestSquare(asList(asList(0, 1), asList(1, 1))));
        assertEquals(4, Q18.largestSquare(asList(asList(1, 1), asList(1, 1))));
        assertEquals(4, Q18.largestSquare(asList(asList(0, 1, 1), asList(0, 1, 1))));
    }

    @Theory
    public void compareLargestSquare(@ForAll @InRange(minInt = 0, maxInt = 1) List<List<Integer>> A) {
        if (Q18.isMatrix(A)) {
            int expected = Q18.largestSquareSlow(A);
            int actual = Q18.largestSquare(A);
            assertEquals(expected, actual);
        }
    }

    @Theory
    public void compareMaximumSumRectangle(@ForAll @InRange(minInt = -10, maxInt = 10) List<List<Integer>> A) {
        if (Q18.isMatrix(A)) {
            int expected = Q18.maximumSumRectangleSlow(A);
            int actual = Q18.maximumSumRectangle(A);
            assertEquals(expected, actual);
        }
    }
}