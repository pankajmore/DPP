import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TheNicePairTest {

    @Test(timeout = 2000)
    public void test0() {
        int[] A = new int[]{5, 5, 5, 5, 5};
        assertEquals(4, new TheNicePair().solve(A));
    }

    @Test(timeout = 2000)
    public void test1() {
        int[] A = new int[]{1, 1, 1, 1};
        assertEquals(-1, new TheNicePair().solve(A));
    }

    @Test(timeout = 2000)
    public void test2() {
        int[] A = new int[]{2, 3, 5, 7};
        assertEquals(1, new TheNicePair().solve(A));
    }

    @Test(timeout = 2000)
    public void test3() {
        int[] A = new int[]{8, 8, 5, 5, 5};
        assertEquals(4, new TheNicePair().solve(A));
    }

    @Test(timeout = 2000)
    public void test4() {
        int[] A = new int[]{1, 1000, 1000, 1, 1000, 1, 999};
        assertEquals(5, new TheNicePair().solve(A));
    }

    @Test(timeout = 2000)
    public void test5() {
        int[] A = new int[]{1000, 1, 1, 1000};
        assertEquals(3, new TheNicePair().solve(A));
    }

    @Test(timeout = 2000)
    public void test6() {
        int[] A = new int[]{1, 1, 953, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 953, 1, 953, 953, 1, 1, 1, 1, 1, 1, 1, 953, 953, 953, 1, 1, 1, 1, 1, 953, 953, 1, 1, 1, 953, 953, 953, 1};
        assertEquals(15, new TheNicePair().solve(A));
    }

    @Test(timeout = 2000)
    public void test7() {
        int[] A = new int[]{946, 910, 210, 759, 222, 589, 423, 947, 507, 31, 414, 169, 901, 592, 763, 656, 411, 360, 625, 538, 549, 484, 596, 42, 603, 351, 292, 837, 375, 21, 597, 22, 349, 200, 669, 485, 282, 735, 54, 1000};
        assertEquals(39, new TheNicePair().solve(A));
    }
}
