package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

@RunWith(Theories.class)
public class CircularQueueTest {

    @Test
    public void sampleOperations() {
        CircularQueue cq = new CircularQueue(1);
        assert cq.capacity() == 1;
        assert cq.size() == 0;
        assert cq.dequeue() == null;
        cq.enqueue(1);
        assert cq.capacity() == 1;
        assert cq.size() == 1;
        cq.enqueue(2);
        assert cq.size() == cq.capacity() && cq.capacity() == 2;
        cq.enqueue(3);
        assert cq.size() == 3 && cq.capacity() == 4;
        assert cq.dequeue() == 1;
        assert cq.size() == 2;
        assert cq.dequeue() == 2;
        cq.enqueue(4);
        cq.enqueue(5);
        cq.enqueue(6);
        assert cq.size() == 4 && cq.capacity() == 4;
        cq.enqueue(7);
        assert cq.size() == 5 && cq.capacity() == 8;
        assert cq.dequeue() == 3;
    }

    @Theory
    public void compareWithQueue(@ForAll List<Operation> ops) throws Exception {
        Queue<Integer> q = new ArrayDeque<>();
        CircularQueue cq = new CircularQueue(1);

        for (Operation op : ops) {
            if (op instanceof SizeOperation) assert q.size() == cq.size();
            if (op instanceof DequeOperation) assert q.poll().equals(cq.dequeue());
            if (op instanceof EnqueueOperation) {
                q.add(((EnqueueOperation) op).val);
                cq.enqueue(((EnqueueOperation) op).val);
            }
        }

    }

    private abstract class Operation {
    }

    private class SizeOperation extends Operation {
    }

    private class DequeOperation extends Operation {
    }

    private class EnqueueOperation extends Operation {
        int val;

        public EnqueueOperation(int val) {
            this.val = val;
        }
    }

}