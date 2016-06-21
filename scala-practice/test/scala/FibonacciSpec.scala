package scala

import org.scalatest.FlatSpec
import org.scalatest.prop.GeneratorDrivenPropertyChecks._

/**
  * Created by pankaj on 6/21/16.
  */
class FibonacciSpec extends FlatSpec {
  "Sum of F(n) + F(n + 1)" should "equal F(n + 2)" in {
    forAll { (n: Int) =>
      whenever(n > 1) {
        RecursiveFibonacci(n) == RecursiveFibonacci(n - 1) + RecursiveFibonacci(n - 2)
        IterativeFibonacci(n) == IterativeFibonacci(n - 1) + IterativeFibonacci(n - 2)
      }
    }
  }
}
