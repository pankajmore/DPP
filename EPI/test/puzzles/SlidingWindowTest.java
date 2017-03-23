package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.List;

import static puzzles.SlidingWindow.*;

@RunWith(Theories.class)
public class SlidingWindowTest {

  @Theory
  public void compareWithBruteForce(@ForAll List<Integer> A) throws Exception {
    for (int k = 0; k < A.size(); k++)
      assert slidingWindowMax(A, k).equals(slidingWindowMax1(A, k))
          && slidingWindowMax(A, k).equals(slidingWindowMax2(A, k));
  }
}
