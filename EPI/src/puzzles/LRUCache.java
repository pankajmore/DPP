package puzzles;

import java.util.LinkedHashMap;
import java.util.Map;

/** Created by Pankaj on 7/25/15. */
public class LRUCache {
  private final int _capacity;
  private final LinkedHashMap<String, Double> _cache;

  public LRUCache(int capacity) {
    this._capacity = capacity;
    _cache =
        new LinkedHashMap<String, Double>(capacity, 1.0f, true) {
          @Override
          protected boolean removeEldestEntry(Map.Entry<String, Double> e) {
            return this.size() > _capacity;
          }
        };
  }

  /**
   * @param key The ISBN string for a given key
   * @return The dollar price of the book
   */
  public double get(String key) {
    return _cache.get(key);
  }

  /**
   * Store the value in the cache, evict the least recently used entry if cache is full
   *
   * @param key the ISBN string
   * @param value the dollar price of the book
   */
  public void put(String key, double value) {
    _cache.put(key, value);
  }
}
