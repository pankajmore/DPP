package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.generator.InRange;
import org.junit.Assert;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;
import utils.Node;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import static puzzles.AddTwoNumberList.add;

/** Created by pankaj on 5/27/16. */
@RunWith(Theories.class)
public class AddTwoNumberListTest {
  @Test
  public void testAdd() throws Exception {
    Assert.assertEquals(
        add(new Node(new int[] {0}), new Node(new int[] {0})), new Node(new int[] {0}));
    Assert.assertEquals(
        add(new Node(new int[] {1}), new Node(new int[] {1})), new Node(new int[] {2}));
    Assert.assertEquals(
        add(new Node(new int[] {4}), new Node(new int[] {6})), new Node(new int[] {0, 1}));
    Assert.assertEquals(
        add(new Node(new int[] {1, 1}), new Node(new int[] {6})), new Node(new int[] {7, 1}));
    Assert.assertEquals(
        add(new Node(new int[] {1, 2}), new Node(new int[] {9})), new Node(new int[] {0, 3}));
    Assert.assertEquals(
        add(new Node(new int[] {9}), new Node(new int[] {1, 2})), new Node(new int[] {0, 3}));
    Assert.assertEquals(
        add(new Node(new int[] {9}), new Node(new int[] {1, 2})), new Node(new int[] {0, 3}));
  }

  @Theory
  public void compareWithBigInteger(
      @ForAll @InRange(minInt = 0, maxInt = 9) int[] A,
      @ForAll @InRange(minInt = 0, maxInt = 9) int[] B)
      throws Exception {
    if (A.length == 0 || B.length == 0) return;

    StringBuilder sb = new StringBuilder();
    for (int v : A) sb.append(v);
    BigInteger b1 = new BigInteger(sb.reverse().toString());

    sb = new StringBuilder();
    for (int v : B) sb.append(v);
    BigInteger b2 = new BigInteger(sb.reverse().toString());

    BigInteger expected = b1.add(b2);

    Node n1 = new Node(A), n2 = new Node(B);
    List<Integer> l = AddTwoNumberList.add(n1, n2).toList();
    Collections.reverse(l);
    sb = new StringBuilder();
    for (int v : l) sb.append(v);
    BigInteger actual = new BigInteger(sb.toString());

    Assert.assertEquals(expected, actual);
  }
}
