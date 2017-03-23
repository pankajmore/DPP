package puzzles;

import examples.BinaryTreeExample;
import org.junit.Test;
import utils.BinaryTreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static puzzles.ExteriorBinaryTree.exterior;

/** Created by pankaj on 2/22/16. */
public class ExteriorBinaryTreeTest {

  @Test
  public void testExterior() throws Exception {
    List<Integer> expected = Arrays.asList(314, 6, 271, 28, 0, 17, 641, 257, 28, 271, 6);
    List<Integer> actual =
        exterior(BinaryTreeExample.constructBookExample())
            .stream()
            .map(BinaryTreeNode::val)
            .collect(Collectors.toList());
    assert expected.equals(actual);
  }
}
