import org.junit.Test;

import java.util.Arrays;

/**
 * Created by pankaj on 3/2/16.
 */
public class BooleanParenthesizingTest {

    @Test
    public void testNumWaysTrue() throws Exception {
        assert BooleanParenthesizing.numWaysTrue(Arrays.asList(true), Arrays.asList()) == 1;
        assert BooleanParenthesizing.numWaysTrue(Arrays.asList(false), Arrays.asList()) == 0;
        assert BooleanParenthesizing.numWaysTrue(Arrays.asList(true, false, true), Arrays.asList('^', '&')) == 2;
        assert BooleanParenthesizing.numWaysTrue(Arrays.asList(true, false, false), Arrays.asList('^', '|')) == 2;
        assert BooleanParenthesizing.numWaysTrue(Arrays.asList(true, true, false, true), Arrays.asList('|', '&', '^')) == 4;
    }

    @Test
    public void testNumWaysTrueIterative() throws Exception {
        assert BooleanParenthesizing.numWaysTrueIterative(Arrays.asList(true), Arrays.asList()) == 1;
        assert BooleanParenthesizing.numWaysTrueIterative(Arrays.asList(false), Arrays.asList()) == 0;
        assert BooleanParenthesizing.numWaysTrueIterative(Arrays.asList(true, false, true), Arrays.asList('^', '&')) == 2;
        assert BooleanParenthesizing.numWaysTrueIterative(Arrays.asList(true, false, false), Arrays.asList('^', '|')) == 2;
        assert BooleanParenthesizing.numWaysTrueIterative(Arrays.asList(true, true, false, true), Arrays.asList('|', '&', '^')) == 4;
    }
}