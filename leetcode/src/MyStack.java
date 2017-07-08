import java.util.ArrayDeque;
import java.util.Deque;

/** https://leetcode.com/problems/implement-stack-using-queues/ Created by pankaj on 08/07/17. */
class MyStack {
  private Deque<Integer> q;

  /** Initialize your data structure here. */
  MyStack() {
    q = new ArrayDeque<>();
  }

  /** Push element x onto stack. */
  void push(final int x) {
    q.add(x);
    for (int i = 0; i < q.size() - 1; i++) {
      q.add(q.remove());
    }
  }

  /** Removes the element on top of the stack and returns that element. */
  int pop() {
    return q.remove();
  }

  /** Get the top element. */
  int top() {
    return q.peek();
  }

  /** Returns whether the stack is empty. */
  boolean empty() {
    return q.isEmpty();
  }
}
