package dailycodingproblem;

import org.junit.jupiter.api.Test;

import static dailycodingproblem.DCP71.rand5;

class DCP71Test {

  @Test
  void rand5Test() {
    int numTrails = 500000000;
    int[] vals = new int[5];
    for(int i = 0; i < numTrails; i++) {
      vals[rand5() - 1]++;
    }
    for(int val : vals) {
      System.out.println(val);
    }
  }
}