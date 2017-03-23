package puzzles;

import java.util.ArrayList;
import java.util.List;

/** Created by pankaj on 4/12/16. */
public class ProductOfAllExceptSelf {
  /**
   * Time : O(N) Space: O(N)
   *
   * @param A list of N doubles
   * @return another list where L_i = product(A_j such that j != i)
   */
  public static List<Double> productOfAllExceptSelf(List<Double> A) {
    int N = A.size();
    List<Double> B = new ArrayList<>(N);
    double leftProduct = 1.0;
    for (int i = 0; i < N; i++) {
      B.add(leftProduct); // B_i = product from A_0 to A_(i - 1)
      leftProduct *= A.get(i);
    }
    double rightProduct = 1.0;
    for (int i = N - 1; i >= 0; i--) {
      B.set(i, B.get(i) * rightProduct);
      rightProduct *= A.get(i);
    }
    return B;
  }

  /**
   * Time : O(N * N) Space: O(N)
   *
   * @param A list of N doubles
   * @return another list where L_i = product(A_j such that j != i)
   */
  public static List<Double> productOfAllExceptSelf1(List<Double> A) {
    int N = A.size();
    List<Double> B = new ArrayList<>(N);
    for (int i = 0; i < N; i++) {
      double product = 1.0;
      for (int j = 0; j < N; j++) {
        if (i != j) product *= A.get(j);
      }
      B.add(product);
    }
    return B;
  }
}
