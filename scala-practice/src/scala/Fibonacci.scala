package scala

import java.math.MathContext

import scala.annotation.tailrec


/**
  * Created by pankaj on 6/20/16.
  */
trait Fibonacci

case object RecursiveFibonacci extends Fibonacci {
  def apply(n: Int): BigInt = {
    require(n >= 0)
    if (n < 2) return n
    apply(n - 1) + apply(n - 2)
  }
}

case object TailRecursiveFibonacci extends Fibonacci {
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

case object IterativeFibonacci extends Fibonacci {
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
}

case object ClosedFormFibonacci extends Fibonacci {
  val sqrt5 = sqrt(BigDecimal(5, mc), 1 << 10)
  val phi: BigDecimal = (BigDecimal(1, mc) + sqrt5) / BigDecimal(2, mc)
  private val mc = new MathContext(1 << 15)
  private val psi: BigDecimal = BigDecimal(1, mc) - phi

  def sqrt(A: BigDecimal, scale: Int): BigDecimal = {
    val mc = new MathContext(scale)
    var x0 = BigDecimal("0", mc)
    var x1 = BigDecimal(Math.sqrt(A.doubleValue()), mc)
    while (!x0.equals(x1)) {
      x0 = x1
      x1 = A / x0
      x1 = x1 + x0
      x1 = x1 / BigDecimal(2, mc)
    }
    x1
  }

  def apply(n: Int): BigInt = {
    require(n >= 0)
    ((phi.pow(n) - psi.pow(n)) / sqrt5).toBigInt
  }
}

case object ClosedFormFibonacci1 extends Fibonacci {
  private val phi: BigDecimal = ClosedFormFibonacci.phi
  private val sqrt5: BigDecimal = ClosedFormFibonacci.sqrt5

  def apply(n: Int): BigInt = {
    require(n >= 0)
    (phi.pow(n) / sqrt5).toBigInt
  }
}

case object MatrixFibonacci extends Fibonacci {
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

  private def pow(A: SqMatrix, n: Int): SqMatrix = {
    assume(n >= 0)
    @tailrec
    def pow(A: SqMatrix, n: Int, acc: SqMatrix): SqMatrix = {
      if (n == 0) return acc
      if ((n & 1) == 1) pow(multiply(A, A), n >>> 1, multiply(acc, A))
      else pow(multiply(A, A), n >>> 1, acc)
    }
    pow(A, n, I)
  }

  private def multiply(A: SqMatrix, B: SqMatrix): SqMatrix = {
    Array(Array(A(0)(0) * B(0)(0) + A(0)(1) * B(1)(0), A(0)(0) * B(0)(1) + A(0)(1) * B(1)(1)),
      Array(A(1)(0) * B(0)(0) + A(1)(1) * B(1)(0), A(1)(0) * B(0)(1) + A(1)(1) * B(1)(1)))
  }
}
