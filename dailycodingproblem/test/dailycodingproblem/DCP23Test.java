package dailycodingproblem;

import org.junit.jupiter.api.Test;

import static dailycodingproblem.DCP23.minSteps;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DCP23Test {

    @Test
    void minStepsTest() {
        boolean[][] grid = {
                {false, false, false, false},
                {true, true, false, true},
                {false, false, false, false},
                {false, false, false, false}
        };
        assertEquals(7, minSteps(grid, 3, 0, 0, 0));
    }
}
