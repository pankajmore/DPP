package dp;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.generator.InRange;
import dp.Q14.Move;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static dp.Q14.Move.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by pankaj on 22/11/16.
 */
@RunWith(Theories.class)
public class Q14Test {
    @Test
    public void maxScore() throws Exception {
        assertEquals(0, Q14.maxScore(Collections.emptyList()));
        assertEquals(1, Q14.maxScore(Collections.singletonList(LEFT)));
        assertEquals(1, Q14.maxScore(Collections.singletonList(RIGHT)));
        assertEquals(0, Q14.maxScore(Collections.singletonList(UP)));
        assertEquals(0, Q14.maxScore(Collections.singletonList(DOWN)));

        assertEquals(2, Q14.maxScore(Arrays.asList(LEFT, LEFT)));
        assertEquals(2, Q14.maxScore(Arrays.asList(RIGHT, RIGHT)));
        assertEquals(1, Q14.maxScore(Arrays.asList(UP, UP)));
        assertEquals(1, Q14.maxScore(Arrays.asList(DOWN, DOWN)));

        assertEquals(0, Q14.maxScore(Arrays.asList(UP, DOWN)));
        assertEquals(1, Q14.maxScore(Arrays.asList(UP, DOWN, LEFT)));
        assertEquals(1, Q14.maxScore(Arrays.asList(UP, DOWN, RIGHT)));

        assertEquals(4, Q14.maxScore(Arrays.asList(DOWN, RIGHT, UP, DOWN, UP, LEFT, DOWN)));
    }

    @Theory
    public void compare(@ForAll @InRange(minInt = 0, maxInt = 3) List<Integer> A) {
        if (A.size() > 20) return;
        List<Move> moves = new ArrayList<>();
        Move[] m = Move.values();
        A.forEach((x) -> moves.add(m[x]));
        int expected = Q14.maxScoreSlow(moves);
        int actual = Q14.maxScore(moves);
        assertEquals(expected, actual);
    }
}