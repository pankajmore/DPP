package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static puzzles.ReverseWords.reverseWords;

@RunWith(Theories.class)
public class ReverseWordsTest {

    @Test
    public void testReverseWords() {
        assert Arrays.equals(reverseWords("".toCharArray()), "".toCharArray());
        assert Arrays.equals(reverseWords("Bob".toCharArray()), "Bob".toCharArray());
        assert Arrays.equals(reverseWords("Alice likes Bob".toCharArray()), "Bob likes Alice".toCharArray());
    }

    @Theory
    public void reverseReverse(@ForAll char[] s) {
        assert Arrays.equals(reverseWords(reverseWords(s)), s);
    }
}