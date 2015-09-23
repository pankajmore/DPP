package puzzles;

import org.junit.Test;

public class GassingUpTest {

    @Test
    public void testZeroCity() {
        int[] A = {};
        assert new GassingUp(A, A).ampleCity() == -1;
    }

    @Test
    public void testNegSum() {
        int[] capacity = {1, 1, 1};
        int[] distance = {1, 2, 1};
        assert new GassingUp(capacity, distance).ampleCity() == -1;
    }

    @Test
    public void testAllPositive() {
        int[] capacity = {2, 2, 2};
        int[] distance = {1, 0, 1};
        GassingUp G = new GassingUp(capacity, distance);
        assert G.check(G.ampleCity());
        assert G.check(0);
        assert G.check(1);
        assert G.check(2);
    }

    @Test
    public void test1() {
        int[] capacity = {2, 1, -5, 2};
        int[] distance = {0, 0, 0, 0};
        GassingUp G = new GassingUp(capacity, distance);
        assert G.check(G.ampleCity());
        assert !G.check(0);
        assert !G.check(1);
        assert !G.check(2);
        assert G.check(3);
    }

    @Test
    public void test2() {
        int[] capacity = {-3, -1, 1, 2, 1};
        int[] distance = {0, 0, 0, 0, 0};
        GassingUp G = new GassingUp(capacity, distance);
        assert G.check(G.ampleCity());
        assert !G.check(0);
        assert !G.check(1);
        assert G.check(2);
        assert !G.check(3);
        assert !G.check(4);
    }

    @Test
    public void test3() {
        int[] capacity = {1, 2, 3, -4};
        int[] distance = new int[capacity.length];
        GassingUp G = new GassingUp(capacity, distance);
        assert G.check(G.ampleCity());
        assert G.check(0);
        assert G.check(1);
        assert !G.check(2);
        assert !G.check(3);
    }

    @Test
    public void testBookExample() {
        int[] capacity = {400, 300, 300, 300, 700, 500, 600, 300, 1300, 900, 200, 900, 500};
        int[] distance = {300, 400, 1000, 300, 300, 600, 400, 1100, 400, 1000, 200, 300, 300};
        GassingUp G = new GassingUp(capacity, distance);
        assert G.check(G.ampleCity());
        assert G.check(8);
    }
}