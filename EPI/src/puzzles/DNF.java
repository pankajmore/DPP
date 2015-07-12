package puzzles;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by pankajm on 5/25/15.
 */

public class DNF {
    private ArrayList<Integer> A;

    public DNF(ArrayList<Integer> a) {
        A = a;
    }

    private class Comp1 implements Comparator<Integer>{

        @Override
        public int compare(Integer a, Integer x) {
            if(a>=x) return 1;
            else return -1;
        }
    }
    public class Comp2 implements Comparator<Integer>{

        @Override
        public int compare(Integer a, Integer x) {
            if(a>x) return 1;
            else return -1;
        }
    }
    public int partition(int i, int j, int x, Comparator<Integer> c){
        while(i<j){
            int c1 = c.compare(A.get(i),x);
            int c2 = c.compare(A.get(j),x);
            if(c1 == 1 && c2 == -1){
                swap(i,j);
                i++;
                j--;
            }
            else if(c1 == -1) i++;
            else if(c2 == 1) j--;
        }
        return i;
    }

    public ArrayList<Integer> dnf(int x){
        int ii = partition(0, A.size()-1, x, new Comp1());
        int jj = partition(ii, A.size()-1, x, new Comp2());
        return A;
    }

    /*
        The following invariant always holds true
        smaller : A[0:smaller-1]
        equal: A[smaller:equal-1]
        uncategorized : A[equal:larger-1]
        larger : A[larger:A.size()-1]
     */
    //TODO : check the correctness of this solution
    public ArrayList<Integer> dnf1(int x) {
        int smaller = 0, equal = 0, larger = A.size() - 1;
        while(equal < larger) {
            int curr = A.get(equal);
            if (curr < x) {
                swap(smaller, equal);
                smaller++;
                equal++;
            }
            if (curr == x) {
                equal++;
            }
            if (curr > x) {
                swap(equal, larger);
                larger--;
            }
        }
        return A;
    }

    private void swap(int i, int j) {
        A.set(i,A.get(i)^A.get(j));
        A.set(j,A.get(i)^A.get(j));
        A.set(i,A.get(i)^A.get(j));
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        PrintStream out = new PrintStream(System.out);
        int N = in.nextInt();
        ArrayList<Integer> A = new ArrayList<Integer>(N);
        for(int i=0;i<N;i++) A.add(in.nextInt());
        int x  = in.nextInt();

        out.println(new DNF(A).dnf1(x));
        out.println(new DNF(A).dnf(x));
    }
}
