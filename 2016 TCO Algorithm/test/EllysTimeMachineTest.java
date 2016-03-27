import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EllysTimeMachineTest {

    @Test(timeout = 2000)
    public void test0() {
        String time = "11:20";
        assertEquals("04:55", new EllysTimeMachine().getTime(time));
    }

    @Test(timeout = 2000)
    public void test1() {
        String time = "02:25";
        assertEquals("05:10", new EllysTimeMachine().getTime(time));
    }

    @Test(timeout = 2000)
    public void test2() {
        String time = "06:30";
        assertEquals("06:30", new EllysTimeMachine().getTime(time));
    }

    @Test(timeout = 2000)
    public void test3() {
        String time = "05:55";
        assertEquals("11:25", new EllysTimeMachine().getTime(time));
    }

    @Test(timeout = 2000)
    public void test4() {
        String time = "03:45";
        assertEquals("09:15", new EllysTimeMachine().getTime(time));
    }

    @Test(timeout = 2000)
    public void test5() {
        String time = "01:00";
        assertEquals("12:05", new EllysTimeMachine().getTime(time));
    }
}
