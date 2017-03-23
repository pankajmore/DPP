package puzzles;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static puzzles.KLargestElementsBinaryHeap.kLargestInBinaryHeap;

/** Created by pankaj on 3/11/16. */
public class KLargestElementsBinaryHeapTest {

  @Test
  public void testKLargest() throws Exception {
    assert kLargestInBinaryHeap(Arrays.asList(10, 8, 9, 4, 3, 6, 7, 2, 1), 5)
        .equals(Arrays.asList(10, 9, 8, 7, 6));

    List<Integer> maxHeap = Arrays.asList(10, 2, 9, 2, 2, 8, 8, 2, 2, 2, 2, 7, 7, 7, 7);
    List<Integer> result = kLargestInBinaryHeap(maxHeap, 3);
    List<Integer> expectedResult = Arrays.asList(10, 9, 8);
    assert (result.equals(expectedResult));
    result = kLargestInBinaryHeap(maxHeap, 5);
    expectedResult = Arrays.asList(10, 9, 8, 8, 7);
    assert (result.equals(expectedResult));

    maxHeap = Arrays.asList(97, 84, 93, 83, 81, 90, 79, 83, 55, 42, 21, 73);
    result = kLargestInBinaryHeap(maxHeap, 3);
    expectedResult = Arrays.asList(97, 93, 90);
    assert (result.equals(expectedResult));

    maxHeap = Arrays.asList(100, 1, 5, 0, 0);
    result = kLargestInBinaryHeap(maxHeap, 1);
    expectedResult = Arrays.asList(100);
    assert (result.equals(expectedResult));
    result = kLargestInBinaryHeap(maxHeap, 2);
    assert (result.equals(Arrays.asList(100, 5)));
    result = kLargestInBinaryHeap(maxHeap, 3);
    assert (result.equals(Arrays.asList(100, 5, 1)));
  }
}
