package puzzles;

import utils.BinaryTreeNode;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Pankaj on 8/6/15.
 */
public class FindKLargestBST {
    public static List<Integer> findKLargestInBSTTrivial(BinaryTreeNode t, int k) {
        List<Integer> vals = t.inOrder().stream().map(n -> n.val()).collect(Collectors.toList());
        Collections.reverse(vals);
        if (k > vals.size())
            return vals;
        return vals.subList(0, k);
    }
}
