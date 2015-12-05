package puzzles;

import utils.Node;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Pankaj on 6/7/15.
 */
public class MergeSortedLists {
    public static Node sortList(Node l) {
        if (l == null || l.next == null) return l;
        Node prev = null;
        Node slow = l;
        Node fast = l;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        assert prev != null;
        prev.next = null;
        Node sortedL = sortList(l);
        Node sortedR = sortList(slow);
        return mergeSortedLists(sortedL, sortedR);
    }

    public static Node mergeSortedLists(Node l, Node r) {
        Node cl = l, cr = r, head, curr;
        if (l.val < r.val) {
            head = l;
            cl = cl.next;
        } else {
            head = r;
            cr = cr.next;
        }
        curr = head;
        while (cl != null && cr != null) {
            if (cl.val < cr.val) {
                curr.next = cl;
                cl = cl.next;
            } else {
                curr.next = cr;
                cr = cr.next;
            }
            curr = curr.next;
        }
        if (cl == null) {
            curr.next = cr;
        } else {
            curr.next = cl;
        }
        return head;
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintStream out = new PrintStream(System.out);
        int M = in.nextInt();
        int[] L = new int[M];
        for (int i = 0; i < M; i++) L[i] = in.nextInt();
        int N = in.nextInt();
        int[] R = new int[N];
        for (int i = 0; i < N; i++) R[i] = in.nextInt();
        Node l = new Node(L);
        Node r = new Node(R);
        out.println(l.toString());
        out.println(r.toString());
        Node m = mergeSortedLists(l, r);
        out.println(m.toString());
    }

}
