package puzzles;

import java.util.SortedMap;
import java.util.TreeMap;

/** Created by pankaj on 2/10/16. */
public class LRUCacheUsingSortedMap {
  private final int _capacity;
  private final SortedMap<Integer, Integer> _keyToVal;
  private final SortedMap<Integer, Integer> _idToKey;
  private final SortedMap<Integer, Integer> _keyToId;
  private int _counter;

  /** @param capacity the cache has a capacity N */
  public LRUCacheUsingSortedMap(int capacity) {
    _capacity = capacity;
    _keyToVal = new TreeMap<>();
    _keyToId = new TreeMap<>();
    _idToKey = new TreeMap<>();
    _counter = 0;
  }

  /**
   * Time : O(log(N))
   *
   * @param key the key to lookup
   * @return the value in the cache if exists else -1
   */
  public int get(int key) {
    if (!_keyToVal.containsKey(key)) return -1;
    _counter++;
    updateId(key);
    return _keyToVal.get(key);
  }

  /**
   * Time : O(log(N))
   *
   * @param key the key for the cache lookup
   * @param value the value pointed to by key
   */
  public void set(int key, int value) {
    if (_keyToVal.containsKey(key)) {
      get(key);
    } else {
      if (_keyToVal.size() == _capacity) evict();
      _counter++;
      _keyToId.put(key, _counter);
      _idToKey.put(_counter, key);
    }
    _keyToVal.put(key, value);
  }

  private void updateId(int key) {
    int id = _keyToId.get(key);
    _keyToId.remove(key);
    _idToKey.remove(id);
    _keyToId.put(key, _counter);
    _idToKey.put(_counter, key);
  }

  private void evict() {
    int id = _idToKey.firstKey();
    int key = _idToKey.get(id);
    _idToKey.remove(id);
    _keyToId.remove(key);
    _keyToVal.remove(key);
  }
}
