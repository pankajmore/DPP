package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static puzzles.RotateArray.rotateArray;
import static puzzles.RotateArray.rotateArray1;

/**
 * Created by pankaj on 3/22/16.
 */
@RunWith(Theories.class)
public class RotateArrayTest {

    @Theory
    public void testRotateArray(@ForAll int[] A, @ForAll int k) throws Exception {
        k = Math.abs(k);
        int[] B = Arrays.copyOf(A, A.length);
        rotateArray(A, k);
        rotateArray1(B, k);
        assert Arrays.equals(A, B);
    }
}