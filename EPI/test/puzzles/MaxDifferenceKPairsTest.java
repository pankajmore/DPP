package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.List;

import static puzzles.MaxDifferenceKPairs.maxKPairsProfits;
import static puzzles.MaxDifferenceKPairs.maxKPairsProfits1;

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
            assert Math.abs(actual - expected) <= 1E-7;
        }
    }
}