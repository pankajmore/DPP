package utils;

import java.util.Comparator;
import java.util.PriorityQueue;

/** Created by Pankaj on 1/2/16. */
public class StackUsingHeap {
  private final PriorityQueue<Item> _heap;
  private long _currentID;

  public StackUsingHeap() {
    _heap = new PriorityQueue<>(Comparator.reverseOrder());
    _currentID = 0;
  }

  public void push(int x) {
    _heap.add(new Item(_currentID++, x));
  }

  public int peek() {
    return _heap.peek().val;
  }

  public int pop() {
    _currentID--;
    return _heap.remove().val;
  }

  private static class Item implements Comparable<Item> {
    private final long id;
    private final int val;

    private Item(long id, int val) {
      this.id = id;
      this.val = val;
    }

    @Override
    public int compareTo(Item o) {
      return Long.compare(this.id, o.id);
    }
  }
}
