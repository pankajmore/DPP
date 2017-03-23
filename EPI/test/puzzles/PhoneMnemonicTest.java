package puzzles;

import org.junit.Test;

import java.util.Arrays;

import static puzzles.PhoneMnemonic.phoneMnemonic;

/** Created by pankaj on 4/29/16. */
public class PhoneMnemonicTest {
  @Test
  public void testPhoneMnemonic() throws Exception {
    assert phoneMnemonic("2").equals(Arrays.asList("A", "B", "C"));
    assert phoneMnemonic("23")
        .equals(Arrays.asList("AD", "AE", "AF", "BD", "BE", "BF", "CD", "CE", "CF"));
  }
}
