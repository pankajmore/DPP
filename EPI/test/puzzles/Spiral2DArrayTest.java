package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import static puzzles.Spiral2DArray.spiral;
import static puzzles.Spiral2DArray.spiral1;

/**
 * Created by pankaj on 4/21/16.
 */
@RunWith(Theories.class)
public class Spiral2DArrayTest {
    @Theory
    public void compare(@ForAll int[][] A) {
        assert spiral(A).equals(spiral1(A));
    }
}