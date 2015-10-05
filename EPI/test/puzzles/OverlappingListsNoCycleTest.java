package puzzles;

import org.junit.Test;
import utils.Node;

import static puzzles.OverlappingListsNoCycle.overlappingListsNoCycle;

public class OverlappingListsNoCycleTest {

    @Test
    public void testOverlappingListsNoCycle() throws Exception {
        Node l1 = new Node(new int[]{1, 2, 3, 4, 5});
        Node l2 = new Node(new int[]{1});
        Node overlap = l1.next.next;
        l2.next = overlap;
        assert overlappingListsNoCycle(l1, l2).equals(overlap);
    }
}