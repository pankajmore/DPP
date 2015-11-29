package puzzles;

import java.util.List;

/**
 * Created by Pankaj on 11/29/15.
 */
public class FindMissingAndDuplicateXOR {
    public static DuplicateAndMissing findDuplicateAndMissing(List<Integer> A) {
        int duplicateOrMissingXOR = 0, n = A.size(), duplicateOrMissing = 0;
        for (int i = 0; i < n; i++) duplicateOrMissingXOR ^= i ^ A.get(i);
        int differBit = duplicateOrMissingXOR & ~(duplicateOrMissingXOR - 1);
        for (int i = 0; i < n; i++) {
            if ((i & differBit) == 1) duplicateOrMissing ^= i;
            if ((A.get(i) & differBit) == 1) duplicateOrMissing ^= A.get(i);
        }
        for (int i = 0; i < n; i++)
            if (A.get(i) == duplicateOrMissing)
                return new DuplicateAndMissing(duplicateOrMissing, duplicateOrMissing ^ duplicateOrMissingXOR);
        return new DuplicateAndMissing(duplicateOrMissing ^ duplicateOrMissingXOR, duplicateOrMissing);
    }

    public static class DuplicateAndMissing {
        public final int duplicate;
        public final int missing;

        public DuplicateAndMissing(int duplicate, int missing) {
            this.duplicate = duplicate;
            this.missing = missing;
        }
    }
}
