package scala

import scala.annotation.tailrec


/**
  * Created by pankaj on 6/20/16.
  */
object RecursiveFibonacci {
  def apply(n: Int): BigInt = {
    require(n >= 0)
    if (n < 2) return n
    apply(n - 1) + apply(n - 2)
  }
}

object TailRecursiveFibonacci {
  def apply(n: Int): BigInt = {
    require(n >= 0)
    if (n < 2) return n
    apply(n, 0, 1)
  }

  @tailrec
  private def apply(n: Int, a: BigInt, b: BigInt): BigInt = {
    if (n == 1) return b
    apply(n - 1, b, a + b)
  }
}

object IterativeFibonacci {
  def apply(n: Int): BigInt = {
    require(n >= 0)
    if (n < 2) return n
    var a: BigInt = 0
    var b: BigInt = 1
    for (i <- 2 to n) {
      val tmp = b
      b = a + b
      a = tmp
    }
    b
  }

  object ClosedFormFibonacci1 {
    val phi: BigDecimal = (1 + Math.sqrt(5)) / 2
    val psi: BigDecimal = 1 - phi

    def apply(n: Int): BigInt = {
      require(n >= 0)
      ((phi.pow(n) - psi.pow(n)) / Math.sqrt(5)).rounded.toBigInt()
    }
  }

  object ClosedFormFibonacci2 {
    val phi: BigDecimal = ClosedFormFibonacci1.phi

    def apply(n: Int): BigInt = {
      require(n >= 0)
      (phi.pow(n) / Math.sqrt(5)).rounded.toBigInt()
    }
  }

  object MatrixFibonacci {
    private type SqMatrix = Array[Array[BigInt]]
    private val I: SqMatrix = Array(Array(1, 0), Array(0, 1))
    private val A: SqMatrix = Array(Array(1, 1), Array(1, 0))

    /*
    * F[n]     = | 1 1 |  F[n - 1]
    * F[n - 1] = | 1 0 |  F[n - 2]
    *
    * F[n]     = | 1 1 |^(n - 1) |1|
    * F[n - 1] = | 1 0 |         |0|
    * */
    def apply(n: Int): BigInt = {
      require(n >= 0)
      pow(A, n - 1)(0)(0)
    }

    private def pow(A: SqMatrix, nn: Int): SqMatrix = {
      var res = I
      var X = A
      var n = nn
      while (n > 0) {
        if (n % 2 == 1) res = multiply(res, X)
        X = multiply(X, X)
        n >>>= 1
      }
      res
    }

    def multiply(A: SqMatrix, B: SqMatrix): SqMatrix = {
      Array(Array(A(0)(0) * B(0)(0) + A(0)(1) * B(1)(0), A(0)(0) * B(0)(1) + A(0)(1) * B(1)(1)),
        Array(A(1)(0) * B(0)(0) + A(1)(1) * B(1)(0), A(1)(0) * B(0)(1) + A(1)(1) * B(1)(1)))
    }
  }

}
