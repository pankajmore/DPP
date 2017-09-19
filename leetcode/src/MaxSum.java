import java.util.HashMap;
import java.util.Map;

/** https://leetcode.com/problems/map-sum-pairs/ Created by pankaj on 19/09/17. */
class MapSum {

  private static final int SIZE = 26;

  private Trie trie;
  private Map<String, Integer> lastValueInserted;

  /** Initialize your data structure here. */
  MapSum() {
    trie = new Trie(0);
    lastValueInserted = new HashMap<>();
  }

  void insert(final String key, final int val) {
    int remove = lastValueInserted.getOrDefault(key, 0);
    lastValueInserted.put(key, val);
    trie.insert(key, val - remove);
  }

  int sum(final String prefix) {
    return trie.sum(prefix);
  }

  class Trie {
    private final Trie[] children;
    private int val;

    Trie(final int v) {
      val = v;
      children = new Trie[SIZE];
    }

    void insert(final String key, final int v) {
      Trie curr = this;
      for (char c : key.toCharArray()) {
        int idx = c - 'a';
        assert idx < SIZE;
        if (curr.children[idx] == null) {
          curr.children[idx] = new Trie(v);
        } else {
          curr.children[idx].val += v;
        }
        curr = curr.children[idx];
      }
    }

    int sum(final String key) {
      Trie curr = this;
      for (char c : key.toCharArray()) {
        int idx = c - 'a';
        assert idx < SIZE;
        if (curr.children[idx] == null) {
          return 0;
        } else {
          curr = curr.children[idx];
        }
      }
      return curr.val;
    }
  }
}
