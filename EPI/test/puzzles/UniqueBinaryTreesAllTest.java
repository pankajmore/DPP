package puzzles;

import org.junit.Test;

import static puzzles.UniqueBinaryTreesAll.generateAllBinaryTrees;

/** Created by pankaj on 3/20/16. */
public class UniqueBinaryTreesAllTest {

  @Test
  public void testGenerateAllBinaryTrees() throws Exception {
    assert generateAllBinaryTrees(1).size() == 1;
    assert generateAllBinaryTrees(2).size() == 2;
    assert generateAllBinaryTrees(3).size() == 5;
    assert generateAllBinaryTrees(4).size() == 14;
    assert generateAllBinaryTrees(5).size() == 42;
    assert generateAllBinaryTrees(10).size() == 16796;
  }
}
