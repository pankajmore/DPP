package puzzles;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Pankaj on 6/7/15.
 */
public class MergeSortedLists {
    public static Node mergeSortedLists(Node l, Node r) {
        Node cl = l, cr = r, head, curr;
        if (l.value < r.value) {
            head = l;
            cl = cl.next;
        } else {
            head = r;
            cr = cr.next;
        }
        curr = head;
        while (cl != null && cr != null) {
            if (cl.value < cr.value) {
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

    public static void main(String[] args) {
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

    public static class Node {
        public int value;
        public Node next;

        public Node(int v, Node next) {
            this.value = v;
            this.next = next;
        }

        public Node(int[] v) {
            this.value = v[0];
            this.next = null;
            Node prev = this;
            for (int i = 1; i < v.length; i++) {
                prev.next = new Node(v[i], null);
                prev = prev.next;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.value);
            Node curr = this.next;
            while (curr != null) {
                sb.append(" -> ");
                sb.append(curr.value);
                curr = curr.next;
            }
            return sb.toString();
        }

    }
}
