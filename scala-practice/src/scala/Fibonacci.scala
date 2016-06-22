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
      ((phi.pow(n) - psi.pow(n)) / Math.sqrt(5)).rounded.toBigInt()
    }
  }

  object ClosedFormFibonacci2 {
    val phi: BigDecimal = ClosedFormFibonacci1.phi

    def apply(n: Int): BigInt = {
      (phi.pow(n) / Math.sqrt(5)).rounded.toBigInt()
    }
  }

}
