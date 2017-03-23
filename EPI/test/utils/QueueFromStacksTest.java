package utils;

import org.junit.Test;

public class QueueFromStacksTest {
  @Test
  public void smallTest() {
    QueueFromStacks q = new QueueFromStacks();
    assert q.isEmpty();
    for (int i = 1; i <= 10; i++) q.enqueue(i);
    assert q.size() == 10;
    for (int i = 1; i <= 5; i++) assert q.dequeue() == i;
    assert q.size() == 5;
    assert !q.isEmpty();
    for (int i = 11; i <= 15; i++) q.enqueue(i);
    assert q.size() == 10;
    for (int i = 6; i <= 15; i++) assert q.dequeue() == i;
    assert q.isEmpty();
    assert q.dequeue() == null;
  }
}
