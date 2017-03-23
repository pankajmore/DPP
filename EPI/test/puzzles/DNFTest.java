package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.generator.InRange;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

/** Created by pankaj on 4/1/16. */
@RunWith(Theories.class)
public class DNFTest {

  @Theory
  public void testDnf(@ForAll @InRange(minInt = 0, maxInt = 2) ArrayList<Integer> A)
      throws Exception {
    List<Integer> L1 = new DNF(new ArrayList<>(A)).dnf(1);
    List<Integer> L2 = new DNF(new ArrayList<>(A)).dnf1(1);
    assert L1.equals(L2);
  }
}
