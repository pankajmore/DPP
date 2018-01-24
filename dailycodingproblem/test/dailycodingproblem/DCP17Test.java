package dailycodingproblem;

import org.junit.jupiter.api.Test;

import static dailycodingproblem.DCP17.longestFilePath;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DCP17Test {

    @Test
    void longestFilePathTest() {
        assertEquals(20, longestFilePath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        assertEquals(
                32,
                longestFilePath(
                        "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }
}
