package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.Assert;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;
import utils.Node;

import java.util.Arrays;
import java.util.List;

import static puzzles.EvenOddMergeLinkedList.*;

@RunWith(Theories.class)
public class EvenOddMergeLinkedListTest {

    @Test
    public void testEvenOddMerge() throws Exception {
        assert evenOddMerge(new Node(new int[]{1})).toList().equals(Arrays.asList(1));
        assert evenOddMerge(new Node(new int[]{1, 2})).toList().equals(Arrays.asList(1, 2));
        assert evenOddMerge(new Node(new int[]{1, 2, 3})).toList().equals(Arrays.asList(1, 3, 2));
        assert evenOddMerge(new Node(new int[]{1, 2, 3, 4})).toList().equals(Arrays.asList(1, 3, 2, 4));
        assert evenOddMerge(new Node(new int[]{1, 2, 3, 4, 5})).toList().equals(Arrays.asList(1, 3, 5, 2, 4));
    }

    @Theory
    public void compareEvenOddMerge(@ForAll int[] A) throws Exception {
        if(A.length == 0) return;
        Assert.assertEquals(evenOddMerge(new Node(A)).toList(), evenOddMerge1(new Node(A)).toList());
    }
}