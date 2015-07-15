package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Pankaj on 7/15/15.
 */
@RunWith(Theories.class)
public class BinarySearchFirstKTest {
    private <T extends Comparable<T>> int linearSearchFirstK(List<T> ls, T k) {
        int index;
        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i).compareTo(k) == 0) {
                index = i;
                return index;
            }
        }
        return -1;
    }

    @Theory
    public void compareWithLinearSearch(@ForAll(sampleSize = 1000) List<Short> ls) {
        Short k = 0;
        Collections.sort(ls);
        if (ls.size() > 0) {
            Random random = new Random();
            k = ls.get(random.nextInt(ls.size()));
        }

        int bIndex = BinarySearchFirstK.binarySearchFirstK(ls, k);
        int lIndex = linearSearchFirstK(ls, k);
        assert (bIndex == lIndex);
    }
}
