package puzzles;

import utils.Node;

/** Created by pankaj on 5/26/16. */
public class ListPivoting {
  public static Node listPivoting(Node l, int x) {
    Node left = new Node(), leftFakeHead = left;
    Node mid = new Node(), midFakeHead = mid;
    Node right = new Node(), rightFakeHead = right;
    while (l != null) {
      if (l.val < x) {
        left.next = l;
        left = left.next;
      } else if (l.val == x) {
        mid.next = l;
        mid = mid.next;
      } else {
        right.next = l;
        right = right.next;
      }
      l = l.next;
    }
    right.next = null;
    mid.next = rightFakeHead.next;
    left.next = midFakeHead.next;
    return leftFakeHead.next;
  }
}
