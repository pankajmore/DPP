package puzzles;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by Pankaj on 11/28/15.
 */
public class OnlineMedian {
    private final PriorityQueue<Integer> _minHeap;
    private final PriorityQueue<Integer> _maxHeap;

    public OnlineMedian() {
        _minHeap = new PriorityQueue<>();
        _maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public Double median() {
        if (size() % 2 == 1) return Double.valueOf(_minHeap.peek());
        else return (_minHeap.peek() + _maxHeap.peek()) / 2.0;
    }

    public void add(int x) {
        if (_minHeap.isEmpty()) _minHeap.add(x);
        else {
            if (x >= _minHeap.peek()) _minHeap.add(x);
            else _maxHeap.add(x);
        }
        balance();
    }

    public int size() {
        return _maxHeap.size() + _minHeap.size();
    }

    private void balance() {
        if (_minHeap.size() > _maxHeap.size() + 1) _maxHeap.add(_minHeap.remove());
        else if (_maxHeap.size() > _minHeap.size()) _minHeap.add(_maxHeap.remove());
    }
}
