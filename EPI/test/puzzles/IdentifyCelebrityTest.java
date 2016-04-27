package puzzles;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static puzzles.IdentifyCelebrity.identifyCelebrity;

/**
 * Created by pankaj on 4/27/16.
 */
public class IdentifyCelebrityTest {
    @Test
    public void testIdentifyCelebrity() throws Exception {
        List<List<Boolean>> A = Arrays.asList(
                Arrays.asList(false, true, true, false),
                Arrays.asList(true, false, true, false),
                Arrays.asList(false, false, true, false),
                Arrays.asList(true, false, true, true));
        assert identifyCelebrity(A) == 2;
    }

}