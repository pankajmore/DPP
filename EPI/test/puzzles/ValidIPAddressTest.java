package puzzles;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static puzzles.ValidIPAddress.getValidIpAddress;

/** Created by pankaj on 2/11/16. */
public class ValidIPAddressTest {

  @Test
  public void testGetValidIPAddress() throws Exception {
    List<String> res1 = getValidIpAddress("255255255255");
    System.out.println(res1);
    assert (res1.size() == 1);
    assert (res1.get(0).equals("255.255.255.255"));

    List<String> res2 = getValidIpAddress("19216811");
    System.out.println(res2);
    assert (res2.size() == 9);

    List<String> res3 = getValidIpAddress("1111");
    System.out.println(res3);
    assert (res3.size() == 1);
    assert (res3.get(0).equals("1.1.1.1"));

    List<String> res4 = getValidIpAddress("11000");
    System.out.println(res4);
    Collections.sort(res4);
    assert (res4.size() == 2);
    assert (res4.get(0).equals("1.10.0.0"));
    assert (res4.get(1).equals("11.0.0.0"));
  }
}
