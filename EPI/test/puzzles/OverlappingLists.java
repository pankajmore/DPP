package puzzles;

import utils.Node;

import static puzzles.OverlappingListsNoCycle.overlappingListsNoCycle;

/** Created by pankaj on 5/14/16. */
public class OverlappingLists {
  /**
   * Time : O(M + N) Space: O(!)
   *
   * @return null if there is no overlap else the overlap point
   * @throws Exception
   */
  public static Node overlappingList(Node l1, Node l2) throws Exception {
    if (l1 == null || l2 == null) return null;
    Node cycleX = l1.checkCycle(), cycleY = l2.checkCycle();
    if (cycleX == null && cycleY == null) return overlappingListsNoCycle(l1, l2);
    if (cycleX != null && cycleY == null || cycleX == null) return null;
    int cyclePos1 = cyclePos(l1, cycleX), cyclePos2 = cyclePos(l2, cycleY);
    if (cycleX == cycleY) {
      l1.breakCycle();
      Node overlap = overlappingListsNoCycle(l1, l2);
      l1.introduceCycle(cyclePos1);
      return overlap;
    } else {
      Node curr = cycleX.next;
      while (curr != cycleX) {
        if (curr == cycleY) {
          return cyclePos1 < cyclePos2 ? cycleX : cycleY;
        }
        curr = curr.next;
      }
      return null;
    }
  }

  private static int cyclePos(Node head, Node cycleStart) {
    Node x = head;
    int cyclePos = 1;
    while (x != cycleStart) {
      x = x.next;
      cyclePos++;
    }
    return cyclePos;
  }
}
