package utils;

import java.util.ArrayList;
import java.util.List;

/** Created by Pankaj on 6/10/15. */
public class Node {
  public int val;
  public Node next;

  public Node() {}

  public Node(int x) {
    this.val = x;
  }

  public Node(int[] A) throws Exception {
    if (A.length == 0) throw (new Exception("Cannot create an empty linked list!"));
    this.val = A[0];
    Node curr = this;
    for (int i = 1; i < A.length; i++) {
      curr.next = new Node();
      curr.next.val = A[i];
      curr = curr.next;
    }
  }

  public static Node prepend(Node h, int x) {
    Node n = new Node();
    n.val = x;
    n.next = h;
    return n;
  }

  public List<Integer> toList() {
    Node curr = this;
    List<Integer> l = new ArrayList<>();
    while (curr != null) {
      l.add(curr.val);
      curr = curr.next;
    }
    return l;
  }

  public int length() {
    Node head = this;
    int len = 0;
    while (head != null) {
      head = head.next;
      len++;
    }
    return len;
  }

  public Node kthNext(int k) {
    Node curr = this;
    while (k-- > 0) {
      curr = curr.next;
      if (curr == null) return null;
    }
    return curr;
  }

  public Node kthLast(int k) throws Exception {
    Node x = this, y = this;
    while (k-- > 0) {
      if (y == null) throw new Exception("Index k out of bounds");
      y = y.next;
    }
    while (y != null) {
      x = x.next;
      y = y.next;
    }
    return x;
  }

  public Node removeKthLast(int k) throws Exception {
    Node n;
    try {
      n = this.kthLast(k + 1);
      Node toBeDeleted = n.next;
      n.next = toBeDeleted.next;
      return this;
    } catch (Exception e) {
      n = this.kthLast(k);
      assert (n == this);
      Node newHead = this.next;
      this.next = null;
      return newHead;
    }
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(val);
    Node curr = next;
    Node startOfCycle = checkCycle();
    if (startOfCycle != null) {
      for (int i = 0; i < 2; i++) {
        while (curr != startOfCycle) {
          sb.append(" -> ");
          sb.append(curr.val);
          curr = curr.next;
        }
        sb.append(" || ");
        sb.append(curr.val);
        curr = curr.next;
      }
      return sb.toString();
    }
    while (curr != null) {
      sb.append(" -> ");
      sb.append(curr.val);
      curr = curr.next;
    }
    return sb.toString();
  }

  public Node introduceCycle(int i) throws Exception {
    Node to = this, from = this;
    if (checkCycle() != null) throw new Exception("already a cycle");
    while (from.next != null) from = from.next;
    while (--i > 0) {
      to = to.next;
      if (to == null) throw (new Exception("index is too large for the list"));
    }
    from.next = to;
    return this;
  }

  public Node breakCycle() throws Exception {
    Node start = checkCycle();
    if (start == null) return this;
    Node end = start;
    while (end.next != start) {
      end = end.next;
      assert end != null;
    }
    end.next = null;
    return this;
  }

  public Node checkCycle() {
    Node slow = this, fast = this;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        slow = this;
        while (fast != slow) {
          slow = slow.next;
          fast = fast.next;
        }
        return slow;
      }
    }
    return null;
  }

  /**
   * Modifies the original list, beware the side effects!
   *
   * @return true if the given linked list is a palindrome else false
   */
  public synchronized boolean isPalindrome() {
    int size = this.length();
    Node x = this;
    Node y = this.kthNext((size - 1) / 2);
    if ((size & 1) == 1) y = y.next; /* for odd, we start from mid + 1 */
    y = y.reverse();
    while (x != null && y != null) {
      if (x.val != y.val) return false;
      x = x.next;
      y = y.next;
    }
    return true;
  }

  public Node reverse() {
    Node curr = this, prev = null, next;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  /**
   * Time : O(N) Space: O(1)
   *
   * @param begin the start index
   * @param end the end index
   * @return modified linked list with the sub-list in [begin, end] reversed
   */
  public Node reverse(int begin, int end) {
    Node dummyHead = new Node();
    dummyHead.next = this;
    Node curr = dummyHead;
    for (int i = 0; i < begin; i++) curr = curr.next;
    Node a = curr, b = a.next, prev = null;
    curr = b;
    for (int i = begin; i <= end; i++) {
      Node next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    a.next = prev;
    b.next = curr;
    return dummyHead.next;
  }

  public Node reverse(int k) {
    Node dummyHead = new Node();
    dummyHead.next = this;
    Node prevTail = dummyHead, head = this, nextHead;
    while (head != null) {
      Node curr = head;
      for (int i = 1; i < k; i++) {
        if (curr == null) {
          prevTail.next = head;
          return dummyHead.next;
        }
        curr = curr.next;
      }
      if (curr == null) {
        prevTail.next = head;
        return dummyHead.next;
      }
      nextHead = curr.next;
      curr.next = null;
      prevTail.next = head.reverse();
      prevTail = head;
      head = nextHead;
    }
    return dummyHead.next;
  }

  /**
   * Time: O(N) Space: O(1)
   *
   * <p>Assumes the list is sorted, behaviour is undefined for "unsorted" lists
   *
   * @return removes the duplicate nodes
   */
  public Node removeDuplicates() {
    Node prev = this, curr = this.next;
    while (curr != null) {
      if (prev.val == curr.val) {
        prev.next = curr.next;
        curr = curr.next;
      } else {
        prev = curr;
        curr = curr.next;
      }
    }
    return this;
  }

  @Override
  public int hashCode() {
    return this.toList().hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || !(o instanceof Node)) return false;
    Node x = (Node) o;
    Node y = this;
    while (x != null && y != null && x.val == y.val) {
      x = x.next;
      y = y.next;
    }
    return x == null && y == null;
  }
}
