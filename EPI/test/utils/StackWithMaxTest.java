package utils;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class StackWithMaxTest {
    @Test
    public void testMax() throws Exception {
        StackWithMax s = new StackWithMax();
        assert (s.isEmpty());
        try {
            s.peek();
            fail();
        } catch (Exception e) {
            assertTrue("Peek should throw an exception on empty stack", true);
        }
        try {
            s.pop();
        } catch (Exception e) {
            assertTrue("Pop should throw an exception on empty stack", true);
        }
        s.push(1);
        assert (s.max() == 1);
        s.push(2);
        assert (s.max() == 2);
        s.pop();
        assert (s.max() == 1);
    }
}