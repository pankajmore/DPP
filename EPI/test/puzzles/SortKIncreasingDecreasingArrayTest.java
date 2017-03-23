package puzzles;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static puzzles.SortKIncreasingDecreasingArray.sortKIncreasingDecreasingArray;

/** Created by pankaj on 3/5/16. */
public class SortKIncreasingDecreasingArrayTest {

  @Test
  public void testSortKIncreasingDecreasingArray() throws Exception {
    List<Integer> A = Arrays.asList(57, 131, 493, 294, 221, 339, 418, 452, 442, 190);
    List<Integer> actual = sortKIncreasingDecreasingArray(A);
    Collections.sort(A);
    assert A.equals(actual);
  }

  @Test
  public void simpleTest() {
    List<Integer> A = Arrays.asList(1, 2, 3, 2, 1, 4, 5, 10, 9, 4, 4, 1, -1);
    List<Integer> Adup = new ArrayList<>(A);
    List<Integer> ans = sortKIncreasingDecreasingArray(A);
    assert (Adup.size() == ans.size());
    Collections.sort(Adup);
    assert (Adup.equals(ans));

    A = Arrays.asList(Integer.MIN_VALUE, -1, 0, 1, 2, 4, 8, Integer.MAX_VALUE);
    Adup = new ArrayList<>(A);
    ans = sortKIncreasingDecreasingArray(A);
    assert (Adup.size() == ans.size());
    assert (Adup.equals(ans));

    A = Arrays.asList(Integer.MIN_VALUE, -1, 0, 1, 2, 4, 8, Integer.MAX_VALUE);
    Adup = new ArrayList<>(A);
    Collections.reverse(A);
    ans = sortKIncreasingDecreasingArray(A);
    assert (Adup.size() == ans.size());
    assert (Adup.equals(ans));
  }
}
