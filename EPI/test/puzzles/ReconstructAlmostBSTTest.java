package puzzles;

import examples.BinaryTreeExample;
import org.junit.Test;
import utils.BinaryTreeNode;

import static org.junit.Assert.*;

/**
 * Created by pankaj on 2/24/16.
 */
public class ReconstructAlmostBSTTest {

    @Test
    public void testReconstructBST() throws Exception {
        BinaryTreeNode almostBST = BinaryTreeExample.almostBST();
        assert !almostBST.isBST();
        new ReconstructAlmostBST().reconstructBST(almostBST);
        assert almostBST.isBST();
    }
}