import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/** https://leetcode.com/problems/flatten-nested-list-iterator/ Created by pankaj on 25/07/17. */
class NestedIterator implements Iterator<Integer> {
  private Deque<Iterator<NestedInteger>> _stack;
  private Integer _next;

  NestedIterator(List<NestedInteger> nestedList) {
    _stack = new ArrayDeque<>();
    _stack.push(nestedList.iterator());
    _next = preComputeNext();
  }

  @Override
  public Integer next() {
    Integer curr = _next;
    _next = preComputeNext();
    return curr;
  }

  @Override
  public boolean hasNext() {
    return _next != null;
  }

  private Integer preComputeNext() {
    while (!_stack.isEmpty()) {
      Iterator<NestedInteger> it = _stack.peek();
      if (it.hasNext()) {
        NestedInteger nestedInteger = it.next();
        if (nestedInteger.isInteger()) {
          return nestedInteger.getInteger();
        } else {
          _stack.push(nestedInteger.getList().iterator());
        }
      } else {
        _stack.pop();
      }
    }
    return null;
  }

  interface NestedInteger {
    boolean isInteger();

    Integer getInteger();

    List<NestedInteger> getList();
  }
}
