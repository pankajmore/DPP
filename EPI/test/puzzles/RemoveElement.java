package puzzles;

/**
 * Created by pankaj on 1/24/16.
 */
public class RemoveElement {
    /**
     * Deletes every instance of elem and shifts the remaining elements to left.
     * The remaining elements are treated as "dirty"
     * <p>
     * Time : O(N)
     * Space : O(1)
     *
     * @param arr  array of N elements
     * @param elem the element to remove
     * @param <T>  the "type" of elements
     * @return the number of remaining "valid" elements
     */
    public static <T> int removeElement(T[] arr, T elem) {
        int j = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] != elem)
                arr[j++] = arr[i];
        return j;
    }
}
