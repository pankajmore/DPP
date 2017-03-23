package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.generator.InRange;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static puzzles.RookAttack.rookAttack;
import static puzzles.RookAttack.rookAttack1;

/** Created by pankaj on 4/26/16. */
@RunWith(Theories.class)
public class RookAttackTest {
  @Theory
  public void compare(@ForAll @InRange(minInt = 0, maxInt = 1) List<List<Integer>> A) {
    List<List<Integer>> B = A.stream().map(ArrayList::new).collect(Collectors.toList());
    rookAttack(A);
    rookAttack1(B);
    assert A.equals(B);
  }
}
