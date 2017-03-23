package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.List;

import static puzzles.BuyAndSellStockTwice.buyAndSellStockTwice;
import static puzzles.BuyAndSellStockTwice.buyAndSellStockTwice1;

/** Created by pankaj on 4/7/16. */
@RunWith(Theories.class)
public class BuyAndSellStockTwiceTest {
  @Theory
  public void compareWithBruteForce(@ForAll List<Double> prices) {
    final double expected = buyAndSellStockTwice1(prices);
    final double actual = buyAndSellStockTwice(prices);
    assert actual == expected;
  }
}
