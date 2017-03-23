package puzzles;

import org.junit.Test;

import static puzzles.Interleave.isInterleavingString;

/** Created by pankaj on 1/31/16. */
public class InterleaveTest {

  @Test
  public void testInterleave() throws Exception {
    assert isInterleavingString("gattaca", "gtaa", "atc");
    assert isInterleavingString("gtataac", "gtaa", "atc");
    assert !isInterleavingString("gatacta", "gtaa", "atc");

    assert isInterleavingString("aadbbcbcac", "aabcc", "dbbca");
    assert !isInterleavingString("aadbbbaccc", "aabcc", "dbbca");
    assert isInterleavingString("aadaaeaabaafaac", "aabaac", "aadaaeaaf");
    assert isInterleavingString("abcbcaab", "bbc", "acaab");
  }
}
