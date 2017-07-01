import java.util.*;

/** https://leetcode.com/problems/insert-delete-getrandom-o1/ Created by pankaj on 01/07/17. */
class RandomizedSet {
  private Map<Integer, Integer> map;
  private List<Integer> values;
  private Random rand;

  /** Initialize your data structure here. */
  RandomizedSet() {
    map = new HashMap<>();
    values = new ArrayList<>();
    rand = new Random();
  }

  /**
   * Inserts a value to the set. Returns true if the set did not already contain the specified
   * element.
   */
  boolean insert(final int val) {
    if (!map.containsKey(val)) {
      map.put(val, values.size());
      values.add(val);
      return true;
    } else {
      return false;
    }
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  boolean remove(final int val) {
    if (map.containsKey(val)) {
      map.put(values.get(values.size() - 1), map.get(val));
      Collections.swap(values, values.size() - 1, map.get(val));
      values.remove(values.size() - 1);
      map.remove(val);
      return true;
    } else {
      return false;
    }
  }

  /** Get a random element from the set. */
  int getRandom() {
    if (values.isEmpty()) {
      throw new IllegalStateException();
    } else {
      return values.get(rand.nextInt(values.size()));
    }
  }
}
