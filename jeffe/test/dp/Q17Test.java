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
 * Created by pankaj on 25/11/16.
 */
@RunWith(Theories.class)
public class Q17Test {
    @Test
    public void maxScoreA() throws Exception {
        assertEquals(Integer.MIN_VALUE, Q17.maxScoreA(emptyList()));
        assertEquals(Integer.MIN_VALUE, Q17.maxScoreA(singletonList(emptyList())));
        assertEquals(-1, Q17.maxScoreA(singletonList(singletonList(-1))));
        assertEquals(2, Q17.maxScoreA(singletonList(asList(-1, 2))));
        assertEquals(3, Q17.maxScoreA(singletonList(asList(1, 2))));
        assertEquals(3, Q17.maxScoreA(asList(singletonList(1), singletonList(2))));

        assertEquals(15, Q17.maxScoreA(asList(
                asList(-1, 7, -8, 10, -5),
                asList(-4, -9, 8, -6, 0),
                asList(5, -2, -6, -6, 7),
                asList(-7, 4, 7, -3, -3),
                asList(7, 1, -6, 4, -9)
        )));
    }

    @Theory
    public void compareA(@ForAll @InRange(minInt = -(1 << 10), maxInt = 1 << 10) List<List<Integer>> A) {
        if (Q17.isMatrix(A) && A.size() < 32) {
            int expected = Q17.maxScoreASlow(A);
            int actual = Q17.maxScoreA(A);
            assertEquals(expected, actual);
        }
    }

}