package puzzles;

import java.util.Random;

/**
 * Created by Pankaj on 9/27/15.
 */
public class ReadersWriters {
    public static void launchReadersWriters(int readers, int readTries, int writers, int writeTries) {
        SharedObject s = new SharedObject(0);
        for (int i = 0; i < readers; i++) new Thread(new Reader(s, readTries), "Reader-" + (i + 1)).start();
        for (int i = 0; i < writers; i++) new Thread(new Writer(s, writeTries), "Writer-" + (i + 1)).start();

    }

    public static void main(String[] args) {
        launchReadersWriters(2, 10, 2, 10);
    }

    private static class SharedObject {
        private final Object writeLock, readLock;
        private Integer data;
        private Integer readers;

        public SharedObject(Integer data) {
            this.data = data;
            this.writeLock = new Object();
            this.readLock = new Object();
            this.readers = 0;
        }

        public void read() {
            synchronized (readLock) {
                readers++;
            }
            System.out.println(Thread.currentThread().getName() + " reads : " + data);
            synchronized (readLock) {
                readers--;
                readLock.notifyAll();
            }
        }

        public void write(Integer data) throws InterruptedException {
            synchronized (writeLock) {
                synchronized (readLock) {
                    while (readers > 0) readLock.wait();
                    this.data = data;
                    System.out.println(Thread.currentThread().getName() + " writes : " + data);
                }
            }
        }
    }

    private static class Reader implements Runnable {
        private SharedObject sharedObject;
        private int tries;

        public Reader(SharedObject s, int tries) {
            this.sharedObject = s;
            this.tries = tries;
        }

        @Override
        public void run() {
            Random r = new Random();
            while (this.tries-- > 0) {
                try {
                    Thread.sleep(r.nextInt(1000));
                    this.sharedObject.read();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Writer implements Runnable {

        private final SharedObject sharedObject;
        private int tries;

        public Writer(SharedObject s, int tries) {
            this.sharedObject = s;
            this.tries = tries;
        }

        @Override
        public void run() {
            Random r = new Random();
            while (this.tries-- > 0) {
                try {
                    Thread.sleep(r.nextInt(1000));
                    this.sharedObject.write(r.nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
