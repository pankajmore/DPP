package scala


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

object IterativeFibonacci {
  def apply(n: Int): BigInt = {
    require(n >= 0)
    if (n < 2) return n
    var a = 0
    var b = 1
    for (i <- 3 to n) {
      val tmp = b
      b = a + b
      a = tmp
    }
    b
  }
}
