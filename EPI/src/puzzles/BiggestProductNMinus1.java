package puzzles;

import java.util.Collections;
import java.util.List;

import static puzzles.ProductOfAllExceptSelf.productOfAllExceptSelf;

/** Created by pankaj on 4/12/16. */
public class BiggestProductNMinus1 {
  /**
   * Time : O(N) Space: O(1)
   *
   * @param A List of N doubles
   * @return max of all products possible excluding self
   */
  public static double findBiggestProduct(List<Double> A) {
    int zeros = 0, neg = 0, N = A.size();
    if (N == 0) return Double.NEGATIVE_INFINITY;
    double
        minNeg = Double.NEGATIVE_INFINITY,
        maxNeg = 0,
        minPos = Double.POSITIVE_INFINITY,
        maxPos = 0;
    for (double x : A) {
      if (x == 0) zeros++;
      else if (x < 0) {
        if (x < maxNeg) maxNeg = x;
        if (x > minNeg) minNeg = x;
        neg++;
      } else {
        if (x < minPos) minPos = x;
        if (x > maxPos) maxPos = x;
      }
    }
    if (zeros > 1) return 0;
    else if (zeros == 1 && neg % 2 == 1) return 0;
    else if (zeros == 1) {
      return computeProduct(A, 0);
    } else { // no zeros
      if (neg == N && neg % 2 == 0) {
        // discard maxNeg as outcome is -ve
        return computeProduct(A, maxNeg);
      } else {
        // outcome is always +ve
        if (neg % 2 == 0) return computeProduct(A, minPos);
        else return computeProduct(A, minNeg);
      }
    }
  }

  private static double computeProduct(List<Double> A, final double toSkip) {
    double product = 1.0;
    boolean alreadySkipped = false;
    for (double x : A) {
      if (x == toSkip & !alreadySkipped) alreadySkipped = true;
      else product *= x;
    }
    return product;
  }

  /**
   * Time : O(N) Space: O(N)
   *
   * @param A List of N doubles
   * @return max of all products possible excluding self
   */
  public static double findBiggestProduct1(List<Double> A) {
    List<Double> products = productOfAllExceptSelf(A);
    return products.size() == 0 ? Double.NEGATIVE_INFINITY : Collections.max(products);
  }

  /**
   * Time : O(N * N) Space: O(1)
   *
   * @param A List of N doubles
   * @return max of all products possible excluding self
   */
  public static double findBiggestProduct2(List<Double> A) {
    double maxProduct = Double.NEGATIVE_INFINITY;
    int N = A.size();
    for (int i = 0; i < N; i++) {
      double product = 1.0;
      for (int j = 0; j < N; j++) {
        if (i != j) product *= A.get(j);
      }
      maxProduct = Math.max(maxProduct, product);
    }
    return maxProduct;
  }
}
