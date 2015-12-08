package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;
import utils.BinaryTreeNode;

import java.util.Arrays;

import static puzzles.BuildBSTFromSortedArray.buildBSTFromSortedArray;

@RunWith(Theories.class)
public class BuildBSTFromSortedArrayTest {

    @Theory
    public void bstFromSortedArrayShouldHaveInOrderSameAsSortedArray(@ForAll Integer[] A) {
        if (A.length == 0) return;
        Arrays.sort(A);
        BinaryTreeNode n = buildBSTFromSortedArray(A);
        assert n.isBST() && n.isBalanced();
        assert n.inOrderVals().equals(Arrays.asList(A));
    }

    @Test
    public void testBuildBSTFromSortedArray() throws Exception {
        Integer[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        BinaryTreeNode n = buildBSTFromSortedArray(A);
        assert n.isBST() && n.isBalanced();
        assert n.inOrderVals().equals(Arrays.asList(A));
    }
}