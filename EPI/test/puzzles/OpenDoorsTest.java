package puzzles;

import org.junit.Test;

import java.util.Arrays;

import static puzzles.OpenDoors.openDoors;

/**
 * Created by pankaj on 1/22/16.
 */
public class OpenDoorsTest {

    @Test
    public void testOpenDoors() throws Exception {
        assert openDoors(100).equals(Arrays.asList(1, 4, 9, 16, 25, 36, 49, 64, 81, 100));
    }
}