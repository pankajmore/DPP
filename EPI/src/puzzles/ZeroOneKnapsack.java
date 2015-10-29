package puzzles;

import java.util.List;

/**
 * Created by Pankaj on 10/27/15.
 */
public class ZeroOneKnapsack {
    public static int knapsack(int capacity, List<Item> items) {
        int N = items.size();
        int[] V = new int[capacity + 1];
        for (int i = 1; i < N; i++)
            for (int w = capacity; w >= items.get(i).weight; w--)
                V[w] = Math.max(V[w], V[w - items.get(i).weight] + items.get(i).value);
        return V[capacity];
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
