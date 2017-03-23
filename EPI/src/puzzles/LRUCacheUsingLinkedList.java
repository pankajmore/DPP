package puzzles;

import java.util.HashMap;
import java.util.Map;

/** Created by pankaj on 2/10/16. */
public class LRUCacheUsingLinkedList {
  private final int _capacity;
  private final Map<Integer, Node> _map;
  private Node last, first;

  public LRUCacheUsingLinkedList(int capacity) {
    _capacity = capacity;
    _map = new HashMap<>();
  }

  public int get(int key) {
    if (!_map.containsKey(key)) return -1;
    Node n = _map.get(key);
    assert last != null;
    moveToLast(n);
    return n.value;
  }

  public void set(int key, int value) {
    if (_map.containsKey(key)) {
      get(key);
      _map.get(key).value = value;
    } else {
      Node n = new Node(key, value);
      addLast(n);
      _map.put(key, n);
      if (_map.size() > _capacity) evict();
    }
  }

  private void evict() {
    _map.remove(first.key);
    Node tmp = first.next;
    remove(first);
    first = tmp;
  }

  private void remove(Node n) {
    if (n == first) first = n.next;
    if (n.prev != null) {
      n.prev.next = n.next;
    }
    if (n.next != null) {
      n.next.prev = n.prev;
    }
    n.prev = null;
    n.next = null;
  }

  private void moveToLast(Node n) {
    if (n == last) return;
    remove(n);
    addLast(n);
  }

  private void addLast(Node n) {
    assert n != last;
    if (last == null) {
      first = n;
      last = n;
    } else {
      last.next = n;
      n.prev = last;
      last = last.next;
    }
  }

  private class Node {
    public int key, value;
    public Node next, prev;

    public Node(int key, int val) {
      this.key = key;
      this.value = val;
    }
  }
}
