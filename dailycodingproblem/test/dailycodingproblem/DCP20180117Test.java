package dailycodingproblem;

import dailycodingproblem.DCP20180117.Trie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static dailycodingproblem.DCP20180117.prefixSearch;
import static dailycodingproblem.DCP20180117.triefy;

class DCP20180117Test {
    @Test
    void prefixSearchTest() {
        Set<String> dict = new HashSet<>(Arrays.asList("foo", "foot", "footer", "foobar", "bar"));
        Trie t = triefy(dict);
        Set<String> actual = prefixSearch("foo", t);
        Set<String> expected = new HashSet<>(Arrays.asList("foo", "foot", "footer", "foobar"));
        Assertions.assertEquals(expected, actual);
    }
}
