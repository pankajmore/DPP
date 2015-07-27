package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Collections;
import java.util.List;

/**
 * Created by Pankaj on 7/27/15.
 */
@RunWith(Theories.class)
public class IntersectionSortedArraysTest {
    @Theory
    public void compareWithTrivial(@ForAll List<Integer> s1, @ForAll List<Integer> s2) {
        Collections.sort(s1);
        Collections.sort(s2);
        List<Integer> ans1 = IntersectionSortedArrays.intersect1(s1, s2);
        List<Integer> ans2 = IntersectionSortedArrays.intersect2(s1, s2);
        List<Integer> ans3 = IntersectionSortedArrays.intersectTrivial(s1, s2);
        assert ans1.equals(ans3);
        assert ans2.equals(ans3);
    }
}
