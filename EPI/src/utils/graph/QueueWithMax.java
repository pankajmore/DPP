package utils.graph;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Pankaj on 12/30/15.
 */
public class QueueWithMax {
    private final Queue<Integer> _q;
    private final Deque<Integer> _max; /* ArrayList would also do! */

    public QueueWithMax() {
        _q = new LinkedList<>();
        _max = new LinkedList<>();
    }

    public void add(int val) {
        while (!_max.isEmpty() && _max.peekLast() < val) _max.removeLast();
        _max.addLast(val);
        _q.add(val);
    }

    public Integer remove() {
        if (_q.isEmpty()) return null;
        assert !_max.isEmpty();
        if (_q.peek().equals(_max.peekFirst())) _max.removeFirst();
        return _q.remove();
    }

    public Integer max() {
        if (_max.isEmpty()) return null;
        return _max.peekFirst();
    }
}
