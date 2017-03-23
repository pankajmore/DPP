package puzzles;

import examples.BinaryTreeExample;
import org.junit.Test;
import utils.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static puzzles.PathSumBinaryTree.*;

/** Created by pankaj on 2/20/16. */
public class PathSumBinaryTreeTest {

  @Test
  public void testLeafWithPathSum() throws Exception {
    assert leafWithPathSum(BinaryTreeExample.constructBookExample(), 591);
  }

  @Test
  public void testPathWithSum() throws Exception {
    BinaryTreeNode root = BinaryTreeExample.constructBookExample();
    List<Integer> path =
        pathWithSum(root, 591).stream().map((n) -> n.val()).collect(Collectors.toList());
    assert path.equals(Arrays.asList(314, 6, 271, 0));
  }

  @Test
  public void testAllPathsWithSum() throws Exception {
    BinaryTreeNode root = BinaryTreeExample.constructBookExample();
    List<List<Integer>> expectedPaths =
        Arrays.asList(Arrays.asList(314, 6, 271, 28), Arrays.asList(314, 6, 271, 28));
    List<List<Integer>> actualPaths = new ArrayList<>();
    for (List<BinaryTreeNode> path : allPathsWithSum(root, 619))
      actualPaths.add(path.stream().map((n) -> n.val()).collect(Collectors.toList()));
    assert actualPaths.equals(expectedPaths);
  }
}
