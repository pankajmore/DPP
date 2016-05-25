package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.Assert;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;
import utils.Node;

import java.util.Arrays;

import static puzzles.MedianCircularSortedLinkedList.median;

/**
 * Created by pankaj on 5/25/16.
 */
@RunWith(Theories.class)
public class MedianCircularSortedLinkedListTest {
    @Test
    public void testMedian() throws Exception {
        Node cycle1 = new Node(1);
        cycle1.next = cycle1;
        Assert.assertEquals(median(cycle1), cycle1.val);

        cycle1.next = new Node(2);
        cycle1.next.next = cycle1;
        Assert.assertEquals(median(cycle1), (1 + 2) / 2);

        cycle1.next.next = new Node(3);
        cycle1.next.next.next = cycle1;
        Assert.assertEquals(median(cycle1), 2);
    }

    @Theory
    public void compare(@ForAll int[] A) throws Exception {
        if (A.length == 0) return;
        Arrays.sort(A);
        int N = A.length;
        int median = N % 2 == 1 ? A[(N - 1) / 2] : (A[N / 2] + A[N / 2 - 1]) / 2;
        Node cycle = new Node(A);
        cycle.kthLast(1).next = cycle;
        Assert.assertEquals(median, median(cycle));
    }
}