package puzzles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pankaj on 9/25/15.
 */
public class OddEven {
    private static final Object lock = new Object();
    private static Integer val = 0;
    private static Integer end = 0;
    private static List<Integer> output = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Odd odd = new Odd();
        Thread oddThread = new Thread(odd);
        Even even = new Even();
        Thread evenThread = new Thread(even);
        oddThread.start();
        evenThread.start();
        while (end != 2) ;
        for (int i = 1; i < 100; i++) assert output.get(i - 1).equals(i);

    }

    private static class Odd implements Runnable {
        @Override
        public void run() {
            while (val < 99) {
                if (val % 2 == 0)
                    synchronized (lock) {
                        val += 1;
                        output.add(val);
                        System.out.println(val);
                    }
            }
            end += 1;
        }
    }

    private static class Even implements Runnable {
        @Override
        public void run() {
            while (val < 100) {
                if (val % 2 == 1)
                    synchronized (lock) {
                        val += 1;
                        output.add(val);
                        System.out.println(val);
                    }
            }
            end += 1;
        }
    }
}
