package puzzles;

import examples.BinaryTreeExample;
import org.junit.Test;
import utils.BinaryTreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static puzzles.ConnectLeavesBinaryTree.createListOfLeaves;

/**
 * Created by pankaj on 2/22/16.
 */
public class ConnectLeavesBinaryTreeTest {

    @Test
    public void testCreateListOfLeaves() throws Exception {
        BinaryTreeNode root = BinaryTreeExample.constructBookExample();
        List<Integer> expected = Arrays.asList(28, 0, 17, 641, 257, 28);
        assert expected.equals(createListOfLeaves(root).stream().map(BinaryTreeNode::val).collect(Collectors.toList()));
    }
}