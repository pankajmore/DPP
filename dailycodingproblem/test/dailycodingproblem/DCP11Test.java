package dailycodingproblem;

import dailycodingproblem.DCP11.Trie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static dailycodingproblem.DCP11.prefixSearch;
import static dailycodingproblem.DCP11.triefy;

class DCP11Test {
    @Test
    void prefixSearchTest() {
        Set<String> dict = new HashSet<>(Arrays.asList("foo", "foot", "footer", "foobar", "bar"));
        Trie t = triefy(dict);
        Set<String> actual = prefixSearch("foo", t);
        Set<String> expected = new HashSet<>(Arrays.asList("foo", "foot", "footer", "foobar"));
        Assertions.assertEquals(expected, actual);
    }
}
