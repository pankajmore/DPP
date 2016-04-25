package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.generator.InRange;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static puzzles.Rotate2DArray.rotate2DArray;
import static puzzles.Rotate2DArray.rotate2DArray1;

/**
 * Created by pankaj on 4/25/16.
 */
@RunWith(Theories.class)
public class Rotate2DArrayTest {
    @Theory
    public void testRotate2DArray(@ForAll int[][] A) {
        final int[][] expected = rotate2DArray1(A);
        final int[][] actual = rotate2DArray(A);
        assert Arrays.deepEquals(actual, expected);
    }
}