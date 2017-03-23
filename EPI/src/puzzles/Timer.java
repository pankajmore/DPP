package puzzles;

import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

/** Created by Pankaj on 11/18/15. */
public class Timer {
  private final TimerThread timerThread = new TimerThread();
  private final TimerTask task;
  private int delay;
  private AtomicBoolean cancelled = new AtomicBoolean(false);

  Timer(TimerTask t) {
    task = t;
  }

  public void schedule(int delay) {
    this.delay = delay;
    timerThread.start();
  }

  public void cancel() {
    cancelled.set(true);
  }

  class TimerThread extends Thread {
    public void run() {
      try {
        Thread.sleep(delay);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      // do we need to synchronize here?
      if (!cancelled.get()) new Thread(task).start();
    }
  }
}
