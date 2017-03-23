package utils;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.List;

/** Created by pankaj on 3/29/16. */
@RunWith(Theories.class)
public class CartesianTreeTest {

  @Theory
  public void testSequence(@ForAll List<Integer> l) throws Exception {
    List<Integer> expected = new CartesianTree(l).sequence();
    assert expected.equals(l);
  }
}
