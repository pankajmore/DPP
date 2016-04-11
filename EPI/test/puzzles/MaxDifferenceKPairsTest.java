package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.List;

import static puzzles.MaxDifferenceKPairs.*;
import static puzzles.MaxDifferenceKPairs.maxKPairsProfits2;

/**
 * Created by pankaj on 4/10/16.
 */
@RunWith(Theories.class)
public class MaxDifferenceKPairsTest {
    @Theory
    public void compareWithBruteForce(@ForAll(sampleSize = 25) List<Double> prices) {
        for (int k = 0; k < prices.size(); k++) {
            double expected = maxKPairsProfits1(prices, k);
            double actual = maxKPairsProfits(prices, k);
            double actual1 = maxKPairsProfits2(prices, k);
            assert Math.abs(actual - expected) <= 1E-7;
            assert Math.abs(actual1 - expected) <= 1E-7;
        }
    }
}