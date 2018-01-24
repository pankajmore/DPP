package dailycodingproblem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static dailycodingproblem.DCP01.interleave;

class DCP01Test {

    @Test
    void interleaveTest1() {
        Stack<Integer> s = new Stack<>();
        s.addAll(Arrays.asList(1, 2, 3, 4));
        interleave(s, new LinkedList<>());
        List<Integer> actual = new ArrayList<>();
        actual.addAll(s);
        Assertions.assertEquals(Arrays.asList(1, 4, 2, 3), s);
    }

    @Test
    void interleaveTest2() {
        Stack<Integer> s = new Stack<>();
        s.addAll(Arrays.asList(1, 2, 3, 4, 5));
        interleave(s, new LinkedList<>());
        List<Integer> actual = new ArrayList<>();
        actual.addAll(s);
        Assertions.assertEquals(Arrays.asList(1, 5, 2, 4, 3), s);
    }
}
