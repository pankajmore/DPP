package dp;

import org.junit.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;

/**
 * Created by pankaj on 25/11/16.
 */
public class Q17Test {
    @Test
    public void maxScoreA() throws Exception {
        assertEquals(Integer.MIN_VALUE, Q17.maxScoreA(emptyList()));
        assertEquals(Integer.MIN_VALUE, Q17.maxScoreA(singletonList(emptyList())));
        assertEquals(-1, Q17.maxScoreA(singletonList(singletonList(-1))));
        assertEquals(2, Q17.maxScoreA(singletonList(asList(-1, 2))));
        assertEquals(3, Q17.maxScoreA(singletonList(asList(1, 2))));
    }
}