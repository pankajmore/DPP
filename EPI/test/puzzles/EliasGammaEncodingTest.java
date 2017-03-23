package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.generator.InRange;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.List;

import static puzzles.EliasGammaEncoding.*;

/** Created by pankaj on 5/3/16. */
@RunWith(Theories.class)
public class EliasGammaEncodingTest {
  @Test
  public void testEncode() {
    assert encode(1).equals("1");
    assert encode(2).equals("010");
    assert encode(3).equals("011");
    assert encode(8).equals("0001000");
  }

  @Test
  public void testDecode() {
    assert decode1("1") == 1;
    assert decode1("010") == 2;
    assert decode1("011") == 3;
    assert decode1("0001000") == 8;
  }

  @Theory
  public void testEncodeAndDecode(@ForAll @InRange(minInt = 1) int x) {
    assert decode1(encode(x)) == x;
  }

  @Theory
  public void testEncodeAndDecodeList(@ForAll @InRange(minInt = 1) List<Integer> A) {
    if (A.isEmpty()) return;
    assert decode(encode(A)).equals(A);
  }
}
