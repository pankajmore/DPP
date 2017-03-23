package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.generator.InRange;
import org.junit.Assert;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;
import utils.Node;

import java.util.Arrays;
import java.util.List;

import static puzzles.CyclicRightShift.cyclicallyRightShift;
import static puzzles.RotateArray.rotateArray;

/** Created by pankaj on 3/21/16. */
@RunWith(Theories.class)
public class CyclicRightShiftTest {

  @Test
  public void testCyclicallyRightShift() throws Exception {
    Node original = new Node(new int[] {1, 2, 3, 4, 5});
    Node shifted = cyclicallyRightShift(original, 3);
    assert shifted.toList().equals(Arrays.asList(3, 4, 5, 1, 2));
  }

  @Theory
  public void compareWithArrayRotate(@ForAll int[] A, @ForAll @InRange(minInt = 0) int k)
      throws Exception {
    if (A.length == 0) return;
    Node l = new Node(A);
    int[] actual = new int[A.length];
    List<Integer> actualList = cyclicallyRightShift(l, k).toList();
    for (int i = 0; i < A.length; i++) actual[i] = actualList.get(i);
    rotateArray(A, k);
    Assert.assertArrayEquals(A, actual);
  }
}
