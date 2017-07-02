import java.util.*;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/ Created by pankaj on
 * 02/07/17.
 */
class RandomizedCollection {
  private Map<Integer, Set<Integer>> map;
  private List<Integer> values;
  private Random rand;

  /** Initialize your data structure here. */
  RandomizedCollection() {
    map = new HashMap<>();
    values = new ArrayList<>();
    rand = new Random();
  }

  /**
   * Inserts a value to the collection. Returns true if the collection did not already contain the
   * specified element.
   */
  boolean insert(final int val) {
    int idx = values.size();
    values.add(val);
    if (!map.containsKey(val)) {
      map.put(val, new HashSet<>());
      map.get(val).add(idx);
      return true;
    } else {
      map.get(val).add(idx);
      return false;
    }
  }

  /**
   * Removes a value from the collection. Returns true if the collection contained the specified
   * element.
   */
  boolean remove(final int val) {
    if (map.containsKey(val)) {
      Set<Integer> idxs = map.get(val);
      Iterator<Integer> iter = idxs.iterator();
      assert iter.hasNext();
      int idxToDelete = iter.next();
      int idxToMove = values.size() - 1;
      int valToMove = values.get(idxToMove);
      values.set(idxToDelete, valToMove);
      values.remove(values.size() - 1);
      idxs.remove(idxToDelete);
      if (idxs.isEmpty()) {
        map.remove(val);
      }
      Set<Integer> toMoveIdxs = map.get(valToMove);
      if (toMoveIdxs != null && toMoveIdxs.contains(idxToMove)) {
        toMoveIdxs.remove(idxToMove);
        toMoveIdxs.add(idxToDelete);
      }
      return true;
    } else {
      return false;
    }
  }

  /** Get a random element from the collection. */
  int getRandom() {
    if (values.isEmpty()) {
      throw new IllegalStateException();
    } else {
      return values.get(rand.nextInt(values.size()));
    }
  }
}
