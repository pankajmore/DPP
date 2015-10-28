package puzzles;

import java.util.List;

/**
 * Created by Pankaj on 10/27/15.
 */
public class ZeroOneKnapsack {
    public static int knapsack(int capacity, List<Item> items) {
        int N = items.size();
        int[][] V = new int[2][capacity + 1];
        for (int i = 1; i < N; i++)
            for (int w = 0; w <= capacity; w++)
                V[i % 2][w] = items.get(i).weight <= w ? Math.max(V[(i - 1) % 2][w], V[(i - 1) % 2][w - items.get(i).weight] + items.get(i).value)
                        : V[(i - 1) % 2][w];
        return V[(N - 1) % 2][capacity];
    }

    public static class Item {
        public final Integer weight;
        public final Integer value;

        public Item(Integer weight, Integer value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
