import org.junit.Test;

/**
 * Created by pankaj on 3/2/16.
 */
public class LongestRepeatingSubsequenceTest {

    @Test
    public void testLongestRepeatingSubsequence() throws Exception {
        assert LongestRepeatingSubsequence.longestRepeatingSubsequence("abc") == 0;
        assert LongestRepeatingSubsequence.longestRepeatingSubsequence("aabb") == 2;
        assert LongestRepeatingSubsequence.longestRepeatingSubsequence("axxxy") == 2;
    }
}