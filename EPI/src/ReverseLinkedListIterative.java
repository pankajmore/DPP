import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Pankaj on 6/9/15.
 */
public class ReverseLinkedListIterative {
    public static class Node{
        public int val;
        public Node next;

        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append(val);
            Node curr = next;
            while(curr != null){
                sb.append(" -> ");
                sb.append(curr.val);
                curr = curr.next;
            }
            return sb.toString();
        }
    }

    public static Node toLinkedList(int[] A){
        if(A.length == 0)
            return null;
        Node head = new Node();
        head.val = A[0];
        Node curr = head;
        for(int i=1;i<A.length;i++){
            curr.next = new Node();
            curr.next.val = A[i];
            curr = curr.next;
        }
        return head;
    }

    public static Node iReverse(Node head){
        Node temp, curr = head, rest = null;
        while(curr != null){
            temp = curr.next;
            curr.next = rest;
            rest = curr;
            curr = temp;
        }
        return rest;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        PrintStream out = new PrintStream(System.out);

        int N = in.nextInt();
        int[] A = new int[N];
        for(int i=0;i<N;i++) A[i] = in.nextInt();
        Node head = toLinkedList(A);
        out.println(head.toString());
        out.println(iReverse(head).toString());

        assert(iReverse(iReverse(head)).equals(head));
    }
}
