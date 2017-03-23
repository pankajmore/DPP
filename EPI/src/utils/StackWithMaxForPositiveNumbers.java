package utils;

import java.util.Stack;

/** Created by pankaj on 4/23/16. */
public class StackWithMaxForPositiveNumbers {
  private java.util.Stack<Integer> _stack;
  private Integer _max;

  public StackWithMaxForPositiveNumbers() {
    _stack = new Stack<>();
    _max = null;
  }

  public void push(int x) {
    if (x <= 0) throw new IllegalArgumentException("Non-positive numbers not supported!");
    if (_max == null || x >= _max) {
      _max = x;
      _stack.add(x);
    } else {
      _stack.add(x - _max);
    }
  }

  public int pop() {
    if (isEmpty()) throw new RuntimeException("empty stack");
    int x = _stack.pop();
    if (x < 0) x += _max;
    _max = isEmpty() ? null : _stack.peek() > 0 ? _stack.peek() : _max;
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
