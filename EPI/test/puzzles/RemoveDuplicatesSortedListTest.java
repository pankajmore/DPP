package puzzles;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static puzzles.RemoveDuplicatesSortedList.removeDuplicates;

public class RemoveDuplicatesSortedListTest {

    @Test
    public void testRemoveDuplicates() throws Exception {
        List<Integer> l = Arrays.asList(2, 3, 5, 5, 7, 11, 11, 11, 13);
        assert removeDuplicates(l) == 6;
        assert l.subList(0, 6).equals(Arrays.asList(2, 3, 5, 7, 11, 13));
    }
}