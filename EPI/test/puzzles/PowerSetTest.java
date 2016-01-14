package puzzles;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static puzzles.PowerSet.*;

/**
 * Created by pankaj on 1/12/16.
 */
public class PowerSetTest {

    @Test
    public void testGeneratePowerSet() throws Exception {
        assert Arrays.asList(
                Collections.emptyList(),
                Collections.singletonList(1),
                Collections.singletonList(2),
                Arrays.asList(1, 2),
                Collections.singletonList(3),
                Arrays.asList(1, 3),
                Arrays.asList(2, 3),
                Arrays.asList(1, 2, 3)

        ).equals(generatePowerSet(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void testGeneratePowerSet1() throws Exception {
        generatePowerSet1(Arrays.asList(1, 2, 3));
    }

    @Test
    public void testGeneratePowerSetUsingBits() throws Exception {
        generatePowerSetUsingBits(Arrays.asList(1, 2, 3));
    }

    @Test
    public void testSubsetsOfFixedSize() throws Exception {
        subsetsOfFixedSize(Arrays.asList(1, 2, 3, 4), 0);
        System.out.println();
        subsetsOfFixedSize(Arrays.asList(1, 2, 3, 4), 1);
        System.out.println();
        subsetsOfFixedSize(Arrays.asList(1, 2, 3, 4), 2);
        System.out.println();
        subsetsOfFixedSize(Arrays.asList(1, 2, 3, 4), 3);
        System.out.println();
        subsetsOfFixedSize(Arrays.asList(1, 2, 3, 4), 4);
    }
}