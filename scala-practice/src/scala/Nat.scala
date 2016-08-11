package scala

/**
  * Created by pankaj on 8/11/16.
  */
abstract class Nat {
  def predecessor: Nat

  def successor: Nat

  def +(that: Nat): Nat

  def -(that: Nat): Nat

  def toInt: Int
}

case object Zero extends Nat {
  def successor = new Succ(Zero)

  def +(that: Nat) = that

  def -(that: Nat) = that match {
    case Zero => this
    case Succ(x) => throw new java.lang.IllegalArgumentException("negative")
  }

  def predecessor = throw new java.lang.IllegalArgumentException("undefined pred of 0")

  def toInt = 0
}

case class Succ(n: Nat) extends Nat {
  def successor = Succ(this)

  def +(that: Nat) = that match {
    case Zero => this
    case Succ(x) => Succ(this) + x
  }

  def -(that: Nat) = that match {
    case Zero => this
    case Succ(x) => n - x
  }

  def predecessor = n

  def toInt = 1 + n.toInt
}
