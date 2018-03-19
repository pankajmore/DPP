package dailycodingproblem;

import org.junit.jupiter.api.Test;

class DCP71Test {

  @Test
  void rand5Test() {
    int numTrails = 500000000;
    int[] vals = new int[5];
    DCP71 dcp71 = new DCP71();
    for(int i = 0; i < numTrails; i++) {
      vals[dcp71.rand5() - 1]++;
    }
    for(int val : vals) {
      System.out.println(val);
    }
  }
}