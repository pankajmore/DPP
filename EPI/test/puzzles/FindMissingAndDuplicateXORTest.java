package puzzles;

import org.junit.Test;
import puzzles.FindMissingAndDuplicateXOR.DuplicateAndMissing;

import java.util.Arrays;
import java.util.List;

import static puzzles.FindMissingAndDuplicateXOR.findDuplicateAndMissing;

public class FindMissingAndDuplicateXORTest {

    @Test
    public void testFindDuplicateAndMissing() throws Exception {
        List<Integer> A = Arrays.asList(0, 1, 2, 4, 5, 6, 6);
        DuplicateAndMissing dm = findDuplicateAndMissing(A);
        assert (dm.duplicate == 6 && dm.missing == 3);

        A = Arrays.asList(0, 0, 1);
        dm = findDuplicateAndMissing(A);
        assert (dm.duplicate == 0 && dm.missing == 2);

        A = Arrays.asList(1, 3, 2, 5, 3, 4);
        dm = findDuplicateAndMissing(A);
        assert (dm.duplicate == 3 && dm.missing == 0);
    }
}