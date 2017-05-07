import java.util.HashSet;
import java.util.Set;

/** https://leetcode.com/problems/distribute-candies/ Created by pankaj on 07/05/17. */
class DistributeCandies {
  int distributeCandies(final int[] candies) {
    Set<Integer> s = new HashSet<>();
    for (int candy : candies) {
      s.add(candy);
    }
    return Math.min(candies.length / 2, s.size());
  }
}
