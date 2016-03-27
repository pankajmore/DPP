import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BadNeighborsTest {

    @Test(timeout = 2000)
    public void test0() {
        int[] donations = new int[]{10, 3, 2, 5, 7, 8};
        assertEquals(19, new BadNeighbors().maxDonations(donations));
    }

    @Test(timeout = 2000)
    public void test1() {
        int[] donations = new int[]{11, 15};
        assertEquals(15, new BadNeighbors().maxDonations(donations));
    }

    @Test(timeout = 2000)
    public void test2() {
        int[] donations = new int[]{7, 7, 7, 7, 7, 7, 7};
        assertEquals(21, new BadNeighbors().maxDonations(donations));
    }

    @Test(timeout = 2000)
    public void test3() {
        int[] donations = new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        assertEquals(16, new BadNeighbors().maxDonations(donations));
    }

    @Test(timeout = 2000)
    public void test4() {
        int[] donations = new int[]{94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,
                6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
                52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72};
        assertEquals(2926, new BadNeighbors().maxDonations(donations));
    }
}
