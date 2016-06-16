package utils;

import examples.BinaryTreeExample;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * Created by pankaj on 6/16/16.
 */
public class ThreadedBinaryTreeTest {
    @Test
    public void testInOrderMorris() {
        ThreadedBinaryTree n = ThreadedBinaryTree.construct(BinaryTreeExample.threadedExample());
        Assert.assertEquals(n.inOrder(), n.inOrderMorris());
        List<ThreadedBinaryTree> inOrder = n.inOrderMorrisReverse();
        Collections.reverse(inOrder);
        Assert.assertEquals(n.inOrder(), inOrder);
    }
}