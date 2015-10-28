package puzzles;

import org.junit.Test;
import puzzles.ZeroOneKnapsack.Item;

import java.util.ArrayList;
import java.util.List;

import static puzzles.ZeroOneKnapsack.knapsack;

public class ZeroOneKnapsackTest {

    @Test
    public void testKnapsack() throws Exception {
        int[] weights = {20, 8, 60, 55, 40, 70, 85, 25, 30, 65, 75, 10, 95, 50, 40, 10};
        int[] values = {65, 35, 245, 195, 65, 150, 275, 155, 120, 320, 75, 40, 200, 100, 220, 99};
        int N = 16;
        int capacity = 130;
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < N; i++) items.add(new Item(weights[i], values[i]));

        assert knapsack(capacity, items) == 695;
    }
}