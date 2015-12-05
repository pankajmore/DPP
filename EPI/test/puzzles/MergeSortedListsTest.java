package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;
import utils.Node;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static puzzles.MergeSortedLists.mergeSortedLists;
import static puzzles.MergeSortedLists.sortList;

@RunWith(Theories.class)
public class MergeSortedListsTest {

    @Theory
    public void sortTheory(@ForAll List<Integer> l) throws Exception {
        if (l.isEmpty()) return;
        int[] arr = new int[l.size()];
        for (int i = 0; i < arr.length; i++) arr[i] = l.get(i);
        final Node head = new Node(arr);
        final List<Integer> actual = sortList(head).toList();
        Collections.sort(l);
        assert actual.equals(l);

    }

    @Test
    public void testSortList() throws Exception {
        final Node l = new Node(new int[]{1, 5, 3, 2, 4});
        final Node sorted = sortList(l);
        assert sorted.toList().equals(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    public void testMergeSortedLists() throws Exception {
        final Node x = new Node(new int[]{1, 3, 5, 7, 9});
        final Node y = new Node(new int[]{2, 4, 6, 8, 10});
        final Node m = mergeSortedLists(x, y);
        assert m.toList().equals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }
}