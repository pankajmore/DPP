package utils.graph;

import java.util.Stack;

/**
 * Created by Pankaj on 11/26/15.
 */
public class QueueFromStacks {
    private final Stack<Integer> _I;
    private final Stack<Integer> _D;

    public QueueFromStacks() {
        _I = new Stack<>();
        _D = new Stack<>();
    }

    public int size() {
        return _I.size() + _D.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void enqueue(int x) {
        _I.push(x);
    }

    public Integer dequeue() {
        if (_D.empty()) {
            if (_I.empty()) return null;
            move();
        }
        return _D.pop();
    }

    private void move() {
        while (!_I.empty()) {
            _D.push(_I.pop());
        }
    }
}
