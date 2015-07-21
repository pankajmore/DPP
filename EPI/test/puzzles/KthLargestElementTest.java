package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RunWith(Theories.class)
public class KthLargestElementTest {
    @Theory
    public void usingPartitionRecursiveTheory(@ForAll List<Integer> l) {
        //Elements in l need to be distinct
        l = new ArrayList<>(new HashSet<>(l));
        for (int k = 0; k < l.size(); k++) {
            Integer expected = KthLargestElement.usingSort(l, k);
            Integer actual = KthLargestElement.usingPartitionRecursive(l, k);
            assert (actual.equals(expected));
        }
    }
}