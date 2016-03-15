package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.List;

import static puzzles.MaxSubmatrixRectangle.maxRectangleSubmatrix;
import static puzzles.MaxSubmatrixRectangle.maxRectangleSubmatrixBruteForce;

/**
 * Created by pankaj on 3/15/16.
 */
@RunWith(Theories.class)
public class MaxSubmatrixRectangleTest {

    @Theory
    public void testMaxRectangleSubmatrix(@ForAll List<List<Boolean>> A) throws Exception {
        int expected = maxRectangleSubmatrixBruteForce(A);
        int actual = maxRectangleSubmatrix(A);
        assert actual == expected;
    }
}