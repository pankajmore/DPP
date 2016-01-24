package puzzles;

import org.junit.Test;

import java.util.Arrays;

import static puzzles.RemoveElement.removeElement;

/**
 * Created by pankaj on 1/24/16.
 */
public class RemoveElementTest {

    @Test
    public void testRemoveElement() throws Exception {
        Integer[] arr = {1, 3, 4, 2, 3, 5, 6};
        assert removeElement(arr, 3) == 5;
        assert Arrays.equals(arr, new Integer[]{1, 4, 2, 5, 6, 5, 6});
    }
}