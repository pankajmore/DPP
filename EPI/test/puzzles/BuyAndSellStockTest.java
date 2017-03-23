package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.List;

import static puzzles.BuyAndSellStock.computeMaxProfit;
import static puzzles.BuyAndSellStock.computeMaxProfit1;

/** Created by pankaj on 4/6/16. */
@RunWith(Theories.class)
public class BuyAndSellStockTest {
  @Theory
  public void compareWithBruteForce(@ForAll List<Double> prices) throws Exception {
    assert computeMaxProfit(prices) == computeMaxProfit1(prices);
  }
}
