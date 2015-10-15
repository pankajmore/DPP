package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

@RunWith(Theories.class)
public class BinarySearchCircularArrayTest {
    @Test
    public void duplicatesTest() {
        Integer[] A = {1, 1, 1, 1, 1, 1, 1, 1, 0, 1};
        assert BinarySearchCircularArray.minIndex(A) != 8;
        assert BinarySearchCircularArray.minIndexWithDuplicatesAllowed(A) == 8;
    }

    @Theory
    public void sameAsMinIndex(@ForAll List<Integer> A) {
        if (A.size() < 1) return;
        Random r = new Random();
        HashSet<Integer> set = new HashSet<>();
        set.addAll(A);
        Integer[] ar = set.toArray(new Integer[0]);
        Arrays.sort(ar);
        int shift = r.nextInt(ar.length);
        rotate(ar, shift);
        assert (shift + 1) % ar.length == BinarySearchCircularArray.minIndex(ar);
    }

    @Theory
    public void sameAsIndex(@ForAll List<Integer> A) {
        if (A.size() < 1) return;
        Random r = new Random();
        HashSet<Integer> set = new HashSet<>();
        set.addAll(A);
        Integer[] ar = set.toArray(new Integer[0]);
        Arrays.sort(ar);
        int shift = r.nextInt(ar.length);
        rotate(ar, shift);
        for (int i = 0; i < ar.length; i++) assert BinarySearchCircularArray.index(ar, ar[i]) == i;
    }

    private void rotate(Integer[] ar, int shift) {
        reverse(ar, 0, ar.length - 1);
        reverse(ar, 0, shift);
        reverse(ar, shift + 1, ar.length - 1);
    }

    private void reverse(Integer[] A, int x, int y) {
        for (int i = x, j = y; i < j; i++, j--) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }
}