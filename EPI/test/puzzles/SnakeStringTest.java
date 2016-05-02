package puzzles;

import org.junit.Test;

import static puzzles.SnakeString.snakeString;

/**
 * Created by pankaj on 5/2/16.
 */
public class SnakeStringTest {
    @Test
    public void testSnakeString() throws Exception {
        assert snakeString("").equals("");
        assert snakeString("a").equals("a");
        assert snakeString("ab").equals("ba");
        assert snakeString("abc").equals("bac");
        assert snakeString("abcd").equals("bacd");
        assert snakeString("abcde").equals("baced");
        assert snakeString("abcdef").equals("bfaced");
        assert snakeString("Hello World!").equals("e lHloWrdlo!");
    }
}