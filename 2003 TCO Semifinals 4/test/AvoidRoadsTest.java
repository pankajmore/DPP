import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AvoidRoadsTest {

    @Test(timeout = 2000)
    public void test0() {
        int width = 6;
        int height = 6;
        String[] bad = new String[]{"0 0 0 1", "6 6 5 6"};
        assertEquals(252L, new AvoidRoads().numWays(width, height, bad));
    }

    @Test(timeout = 2000)
    public void test1() {
        int width = 1;
        int height = 1;
        String[] bad = new String[]{};
        assertEquals(2L, new AvoidRoads().numWays(width, height, bad));
    }

    @Test(timeout = 2000)
    public void test2() {
        int width = 35;
        int height = 31;
        String[] bad = new String[]{};
        assertEquals(6406484391866534976L, new AvoidRoads().numWays(width, height, bad));
    }

    @Test(timeout = 2000)
    public void test3() {
        int width = 2;
        int height = 2;
        String[] bad = new String[]{"0 0 1 0", "1 2 2 2", "1 1 2 1"};
        assertEquals(0L, new AvoidRoads().numWays(width, height, bad));
    }
}
