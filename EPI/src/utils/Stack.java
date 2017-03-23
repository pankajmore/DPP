package utils;

/** Created by Pankaj on 6/11/15. */
//TODO: Stack for generic types
public class Stack {
  private Node head;

  public void push(int x) {
    head = Node.prepend(head, x);
  }

  public int peek() throws Exception {
    if (head == null) throw new Exception("Stack is empty!");
    return head.val;
  }

  public int pop() throws Exception {
    if (head == null) throw new Exception("Stack is empty!");
    int temp = head.val;
    head = head.next;
    return temp;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public String toString() {
    if (head == null) return "Empty";
    return head.toString();
  }
}
