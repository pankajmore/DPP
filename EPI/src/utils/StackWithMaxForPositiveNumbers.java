package utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by pankaj on 4/23/16.
 */
public class StackWithMaxForPositiveNumbers {
    private Deque<Integer> _stack;
    private Integer _max;

    public StackWithMaxForPositiveNumbers() {
        _stack = new ArrayDeque<>();
        _max = null;
    }

    public void push(int x) {
        if (x <= 0) throw new IllegalArgumentException("Non-positive numbers not supported!");
        if (_max == null || x >= _max) {
            _max = x;
            _stack.addLast(x);
        } else {
            _stack.addLast(x - _max);
        }
    }

    public int pop() {
        if (isEmpty()) throw new RuntimeException("empty stack");
        int x = _stack.removeLast();
        if (x < 0) x += _max;
        _max = isEmpty() ? null : _stack.getLast() > 0 ? _stack.getLast() : _max;
        return x;
    }

    public int size() {
        return _stack.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Integer max() {
        return _max;
    }
}
