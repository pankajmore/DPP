package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.generator.InRange;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.List;

import static puzzles.MaxProductTriplets.maxProductTriplets;
import static puzzles.MaxProductTriplets.maxProductTriplets1;

/** Created by pankaj on 4/13/16. */
@RunWith(Theories.class)
public class MaxProductTripletsTest {
  @Theory
  public void compareWithBruteForce(
      @ForAll @InRange(minInt = -1000, maxInt = 1000) List<Integer> A) {
    int expected = maxProductTriplets1(A);
    int actual = maxProductTriplets(A);
    assert actual == expected;
  }
}
