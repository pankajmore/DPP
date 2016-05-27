package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.Assert;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;
import utils.Node;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static puzzles.InsertionSortList.insertionSortList;

/**
 * Created by pankaj on 2/9/16.
 */
@RunWith(Theories.class)
public class InsertionSortListTest {
    @Theory
    public void compareWithJDKSort(@ForAll List<Integer> l) throws Exception {
        if (l.isEmpty()) return;
        int[] A = new int[l.size()];
        for (int i = 0; i < l.size(); i++) A[i] = l.get(i);
        Node head = new Node(A);
        Node sortedHead = insertionSortList(head);
        Collections.sort(l);
        Assert.assertEquals(l, sortedHead.toList());
    }

    @Test
    public void testInsertionSortList() throws Exception {
        Node head = new Node(new int[]{4, 3, 2, 2, 5});
        Node sortedHead = insertionSortList(head);
        Assert.assertEquals(Arrays.asList(2, 2, 3, 4, 5), sortedHead.toList());
    }
}