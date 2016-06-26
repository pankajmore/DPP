package recfun

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || r == 0 || c == r) return 1
    pascal(c, r - 1) + pascal(c - 1, r - 1)
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    @tailrec
    def balance(chars: List[Char], extra: Int): Boolean = {
      if (extra < 0) false
      else if (chars.isEmpty) extra == 0
      else chars.head match {
        case '(' => balance(chars.tail, extra + 1)
        case ')' => balance(chars.tail, extra - 1)
        case _ => balance(chars.tail, extra)
      }
    }
    balance(chars, 0)
  }

  /**x9
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = ???
}
