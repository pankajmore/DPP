package dailycodingproblem;

/**
 * Given a array of numbers representing the stock prices of a company in chronological order, write
 * a function that calculates the maximum profit you could have made from buying and selling that
 * stock once. You must buy before you can sell it.
 */
class DCP47 {
  static int maxProfit(int[] prices) {
    if (prices == null || prices.length <= 1) {
      return 0;
    }
    int min = prices[0];
    int max = 0;
    for (int price : prices) {
      min = Math.min(min, price);
      max = Math.max(max, price - min);
    }
    return max;
  }
}
