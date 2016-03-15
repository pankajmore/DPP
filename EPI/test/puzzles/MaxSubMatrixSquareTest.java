package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.List;

import static puzzles.MaxSubMatrixSquare.maxSquareSubmatrix;
import static puzzles.MaxSubMatrixSquare.maxSquareSubmatrixBruteForce;

/**
 * Created by pankaj on 3/15/16.
 */
@RunWith(Theories.class)
public class MaxSubMatrixSquareTest {

    @Theory
    public void testMaxSquareSubmatrix(@ForAll List<List<Boolean>> A) throws Exception {
        int expected = maxSquareSubmatrixBruteForce(A);
        int actual = maxSquareSubmatrix(A);
        assert actual == expected;
    }
}