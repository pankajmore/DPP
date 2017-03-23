package puzzles;

import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

/** Created by pankaj on 2/10/16. */
public class LRUCacheUsingDeque {
  private int _capacity;
  private Map<Integer, Integer> _map;
  private Map<Integer, Iterator> _iterMap;
  private Deque<Integer> _list;

  public LRUCacheUsingDeque(int capacity) {
    _capacity = capacity;
    _list = new ConcurrentLinkedDeque<>();
    _map = new HashMap<>();
    _iterMap = new HashMap<>();
  }

  public int get(int key) {
    if (!_map.containsKey(key)) return -1;
    updateId(key);
    return _map.get(key);
  }

  public void set(int key, int value) {
    if (_map.containsKey(key)) {
      updateId(key);
      _map.put(key, value);
    } else {
      if (_map.size() == _capacity) evict();
      _map.put(key, value);
      _list.addLast(key);
      _iterMap.put(key, _list.descendingIterator());
    }
  }

  private void updateId(int key) {
    _iterMap.get(key).next();
    _iterMap.get(key).remove();
    _list.addLast(key);
    _iterMap.put(key, _list.descendingIterator());
  }

  private void evict() {
    Integer key = _list.removeFirst();
    _iterMap.remove(key);
    _map.remove(key);
  }
}
