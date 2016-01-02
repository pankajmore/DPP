package utils;

import java.util.PriorityQueue;

/**
 * Created by Pankaj on 1/2/16.
 */
public class QueueUsingHeap {
    private final PriorityQueue<Item> _heap;
    private long _currentID;

    public QueueUsingHeap() {
        _heap = new PriorityQueue<>();
        _currentID = 0;
    }

    public void enqueue(int x) {
        _heap.add(new Item(_currentID++, x));
    }

    public int peek() {
        return _heap.peek().val;
    }

    public int dequeue() {
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
