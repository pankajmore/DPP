package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static puzzles.PermuteArray.permute;
import static puzzles.PermuteArray.permute1;

@RunWith(Theories.class)
public class PermuteArrayTest {

  @Theory
  public void testPermute(@ForAll List<Integer> A) throws Exception {
    List<Integer> perm = IntStream.range(0, A.size()).boxed().collect(Collectors.toList());
    Collections.shuffle(perm);
    List<Integer> expected = permute1(A, perm);
    permute(A, perm);
    assert expected.equals(A);
  }
}
