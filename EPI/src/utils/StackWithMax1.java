package utils;

/**
 * Created by pankaj on 5/29/16. This only needs one entry in _max for multiple repeating values in
 * stack.
 */
public class StackWithMax1<E extends Comparable<E>> extends java.util.Stack<E> {
  private java.util.Stack<E> _max;

  public StackWithMax1() {
    super();
    _max = new java.util.Stack<>();
  }

  public E push(E item) {
    super.push(item);
    if (_max.isEmpty() || _max.peek().compareTo(item) < 0) _max.push(item);
    return item;
  }

  public synchronized E pop() {
    E item = super.pop();
    if (_max.peek() == item) _max.pop();
    return item;
  }

  public E max() {
    return _max.peek();
  }

  int maxSpace() {
    return _max.size();
  }
}
