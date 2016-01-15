package puzzles;

import org.junit.Test;
import puzzles.TreeDiameter.Edge;
import puzzles.TreeDiameter.TreeNode;

import static puzzles.TreeDiameter.computeDiameter;

/**
 * Created by pankaj on 1/15/16.
 */
public class TreeDiameterTest {

    @Test
    public void testComputeDiameter() throws Exception {
        assert (0.0 == computeDiameter(null));
        TreeNode r = new TreeNode();
        r.edges.add(new Edge(new TreeNode(), 10.0));
        r.edges.get(0).root.edges.add(new Edge(new TreeNode(), 50.0));
        r.edges.add(new Edge(new TreeNode(), 20.0));
        assert (80 == computeDiameter(r));
        System.out.println(computeDiameter(r));
        r.edges.get(0).root.edges.add(new Edge(new TreeNode(), 100.0));
        assert (150 == computeDiameter(r));
        System.out.println(computeDiameter(r));
    }
}