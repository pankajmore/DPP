package dailycodingproblem;

/**
 * Assume you have access to a function toss_biased() which returns 0 or 1 with a probability that's
 * not 50-50 (but also not 0-100 or 100-0). You do not know the bias of the coin. Write a function
 * to simulate an unbiased coin toss.
 */
class DCP66 {
  /**
   * @param rng takes a biased rng that generates 0 or 1 with
   * @return
   */
  int tossUnbiased(BiasedRNG rng) {
    int last = rng.tossBiased();
    while (rng.tossBiased() == last) {}
    return last;
  }

  interface BiasedRNG {
    /** @return 0 or 1 with probability != 0.5 */
    int tossBiased();
  }
}
