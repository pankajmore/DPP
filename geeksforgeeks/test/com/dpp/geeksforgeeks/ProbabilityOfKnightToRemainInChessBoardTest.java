package com.dpp.geeksforgeeks;

import org.junit.Assert;
import org.junit.Test;

/** Created by pankaj on 02/05/17. */
public class ProbabilityOfKnightToRemainInChessBoardTest {
  @Test
  public void findProbability() throws Exception {
    Assert.assertEquals(
        1.0, ProbabilityOfKnightToRemainInChessBoard.findProbability1(0, 0, 1, 0), 0.0);
    Assert.assertEquals(
        0.0, ProbabilityOfKnightToRemainInChessBoard.findProbability1(0, 0, 1, 1), 0.0);
    Assert.assertEquals(
        1.0, ProbabilityOfKnightToRemainInChessBoard.findProbability1(0, 0, 3, 0), 0.0);
    Assert.assertEquals(
        2 / 8.0, ProbabilityOfKnightToRemainInChessBoard.findProbability1(0, 0, 3, 1), 0.0);
  }

  @Test
  public void compare() throws Exception {
    for (int size = 1; size <= 16; size++) {
      for (int x = 0; x < size; x++) {
        for (int y = 0; y < size; y++) {
          for (int steps = 0; steps <= 16; steps++) {
            double expected =
                ProbabilityOfKnightToRemainInChessBoard.findProbability1(x, y, size, steps);
            double actual =
                ProbabilityOfKnightToRemainInChessBoard.findProbability(x, y, size, steps);
            Assert.assertEquals(expected, actual, 0.0);
          }
        }
      }
    }
  }
}
