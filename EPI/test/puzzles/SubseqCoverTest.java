package puzzles;

import org.junit.Test;
import puzzles.SubseqCover.SubArray;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static puzzles.SubseqCover.findSmallestSequentiallyCoveringSubset;

public class SubseqCoverTest {

  @Test
  public void testFindSmallestSequentiallyCoveringSubset() throws Exception {
    List<String> a3 =
        Arrays.asList(
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "2", "4", "6", "10", "10", "10", "3",
            "2", "1", "0");
    List<String> subseq4 = Arrays.asList("0", "2", "9", "4", "6");
    SubArray rr = findSmallestSequentiallyCoveringSubset(a3, subseq4);
    assert (rr.start == 0 && rr.end == 9);

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    for (String s : a3) {
      baos.write(s.getBytes());
      baos.write("\n".getBytes());
    }
    InputStream stream = new ByteArrayInputStream(baos.toByteArray());
    rr = findSmallestSequentiallyCoveringSubset(stream, subseq4);
    assert rr.start == 0 && rr.end == 9;
  }
}
