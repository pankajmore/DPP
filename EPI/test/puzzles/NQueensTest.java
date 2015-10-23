package puzzles;

import org.junit.Test;

import static org.junit.Assert.*;
import static puzzles.NQueens.allNQueens;

public class NQueensTest {

    @Test
    public void testAllNQueens() throws Exception {
        assert allNQueens(2).size() == 0;
        assert allNQueens(3).size() == 0;
        assert allNQueens(4).size() == 2;
        assert allNQueens(5).size() == 10;
        assert allNQueens(6).size() == 4;
        assert allNQueens(7).size() == 40;
        assert allNQueens(8).size() == 92;
        assert allNQueens(9).size() == 352;
        assert allNQueens(10).size() == 724;
        assert allNQueens(11).size() == 2680;
        assert allNQueens(12).size() == 14200;

//        Large input
//        assert allNQueens(13).size() == 73712;
//        assert allNQueens(14).size() == 365596;
    }
}