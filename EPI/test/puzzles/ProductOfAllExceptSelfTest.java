package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.List;

import static puzzles.ProductOfAllExceptSelf.productOfAllExceptSelf;
import static puzzles.ProductOfAllExceptSelf.productOfAllExceptSelf1;

/**
 * Created by pankaj on 4/12/16.
 */
@RunWith(Theories.class)
public class ProductOfAllExceptSelfTest {
    @Theory
    public void compareWithBruteForce(@ForAll List<Double> A) {
        List<Double> expected = productOfAllExceptSelf1(A);
        List<Double> actual = productOfAllExceptSelf(A);
        assert expected.size() == actual.size();
        for (int i = 0; i < actual.size(); i++) {
            assert Math.abs(actual.get(i) - expected.get(i)) < 1E-7 * actual.get(i);
        }
    }
}