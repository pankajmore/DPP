package puzzles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pankaj on 9/25/15.
 */
public class OddEven {
    private static final Object lock = new Object();
    private static final List<Integer> output = new ArrayList<>();
    private static Integer val = 0;

    public static List<Integer> oddEvenInterleave(int N) throws InterruptedException {
        Odd odd = new Odd(N);
        Thread oddThread = new Thread(odd);
        Even even = new Even(N);
        Thread evenThread = new Thread(even);
        oddThread.start();
        evenThread.start();
        oddThread.join();
        evenThread.join();
        return output;
    }

    private static class Odd implements Runnable {
        private final int N;

        public Odd(int N) {
            this.N = N;
        }

        @Override
        public void run() {
            int c = 0;
            while (true) {
                c++;
                synchronized (lock) {
                    while (val % 2 == 1) try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    val += 1;
                    if (val > N) {
                        lock.notify();
                        break;
                    }
                    output.add(val);
                    System.out.println(val);
                    lock.notify();
                }
            }
            System.out.println("Odd count : " + c);
        }
    }

    private static class Even implements Runnable {
        private final int N;

        public Even(int N) {
            this.N = N;
        }

        @Override
        public void run() {
            int c = 0;
            while (true) {
                c++;
                synchronized (lock) {
                    while (val % 2 == 0) try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    val += 1;
                    if (val > N) {
                        lock.notify();
                        break;
                    }
                    output.add(val);
                    System.out.println(val);
                    lock.notify();
                }
            }
            System.out.println("Even count : " + c);
        }
    }
}
