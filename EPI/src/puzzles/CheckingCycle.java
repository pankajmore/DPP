package puzzles;

import utils.Node;

import java.io.PrintStream;
import java.util.Scanner;

/** Created by Pankaj on 6/10/15. */
public class CheckingCycle {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    PrintStream out = new PrintStream(System.out);

    int N = in.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < N; i++) A[i] = in.nextInt();
    Node head = new Node(A);

    out.println("Before cycle : ");
    out.println(head.toString());

    assert (head.checkCycle() == null);

    head.introduceCycle(N / 2);

    out.println("After cycle : ");
    out.println(head.toString());

    Node startOfCycle = head.checkCycle();
    assert (startOfCycle != null);
    out.println("Cycle at : " + startOfCycle.val);
  }
}
