package utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void testPush() {
        Stack s = new Stack();
        s.push(1);
        try {
            assert (s.peek() == 1);
        } catch (Exception e) {
            fail("Should not be empty!");
        }
    }

    @Test
    public void testPeek() {
        Stack s = new Stack();
        try {
            s.peek();
            fail("Should have thrown an exception!");
        } catch (Exception e) {
            assertTrue("Peek on empty stack should throw an exception!", true);
        }
    }

    @Test
    public void testPop() {
        Stack s = new Stack();
        try {
            s.pop();
            fail("Should have thrown an exception!");
        } catch (Exception e) {
            assertTrue("Pop on empty stack should throw an exception!", true);
        }
    }

    @Test
    public void testIsEmpty() {
        Stack s = new Stack();
        assertTrue("New stack should be empty!", s.isEmpty());
        s.push(1);
        assertFalse("After a push, it should NOT be empty!", s.isEmpty());
        try {
            s.pop();
        } catch (Exception e) {
            fail("Should not thow exception after a push!");
        }
        assertTrue("It should be empty again after a pop!", s.isEmpty());

    }

    @Test
    public void testToString() {
        assert (new Stack().toString().equals("Empty"));
        Stack s = new Stack();
        s.push(1);
        assert (s.toString().equals("1"));
        s.push(2);
        assert (s.toString().equals("2 -> 1"));
    }
}