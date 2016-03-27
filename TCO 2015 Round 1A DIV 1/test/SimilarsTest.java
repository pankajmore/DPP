import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimilarsTest {

    @Test(timeout = 2000)
    public void test0() {
        int L = 1;
        int R = 10;
        assertEquals(1, new Similars().maxsim(L, R));
    }

    @Test(timeout = 2000)
    public void test1() {
        int L = 1;
        int R = 99;
        assertEquals(2, new Similars().maxsim(L, R));
    }

    @Test(timeout = 2000)
    public void test2() {
        int L = 99;
        int R = 100;
        assertEquals(0, new Similars().maxsim(L, R));
    }

    @Test(timeout = 2000)
    public void test3() {
        int L = 1000;
        int R = 1010;
        assertEquals(2, new Similars().maxsim(L, R));
    }

    @Test(timeout = 2000)
    public void test4() {
        int L = 444;
        int R = 454;
        assertEquals(2, new Similars().maxsim(L, R));
    }
}
