package puzzles;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

/** Created by Pankaj on 10/27/15. */
public class ZeroOneKnapsack {
  public static int knapsack(int capacity, List<Item> items) {
    int N = items.size();
    int[] V = new int[capacity + 1];
    for (int i = 1; i < N; i++)
      for (int w = capacity; w >= items.get(i).weight; w--)
        V[w] = Math.max(V[w], V[w - items.get(i).weight] + items.get(i).value);
    return V[capacity];
  }

  public static double continuousKnapsack(int capacity, List<Item> items) {
    int N = items.size();
    Collections.sort(items, Collections.reverseOrder());
    int currentCapacity = 0, i;
    double currentValue = 0;
    for (i = 0; i < N; i++) {
      if (currentCapacity + items.get(i).weight > capacity) break;
      currentCapacity += items.get(i).weight;
      currentValue += items.get(i).value;
    }
    if (currentCapacity < capacity && i < N)
      currentValue += (capacity - currentCapacity) * (items.get(i).value / items.get(i).weight);
    return currentValue;
  }

  public static class Item implements Comparable<Item> {
    public final Integer weight;
    public final Integer value;

    public Item(Integer weight, Integer value) {
      this.weight = weight;
      this.value = value;
    }

    @Override
    public int compareTo(@NotNull Item o) {
      return Double.compare(this.value / this.weight, o.value / o.weight);
    }
  }
}
