package utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by pankaj on 5/29/16.
 */
public class StackWithMax1Test {
    @Test
    public void testMax() throws Exception {
        StackWithMax1<Integer> s = new StackWithMax1<>();
        s.push(new Integer(1)); //because auto (un)boxing has subtle bugs with == due to caching
        assertEquals(new Integer(1), s.max());
        s.push(new Integer(2));
        assertEquals(new Integer(2), s.max());
        s.push(new Integer(2));
        s.push(new Integer(1));
        s.push(new Integer(2));
        assertEquals(new Integer(2), s.max());
        assertEquals(2, s.maxSpace());
        s.pop();
        s.pop();
        assertEquals(new Integer(2), s.max());
        s.pop();
        assertEquals(new Integer(2), s.max());
        s.pop();
        assertEquals(new Integer(1), s.max());
    }

}