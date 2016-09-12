package quickcheck

import org.scalacheck.Arbitrary._
import org.scalacheck.Gen._
import org.scalacheck.Prop._
import org.scalacheck._

abstract class QuickCheckHeap extends Properties("Heap") with IntHeap {

  lazy val genHeap: Gen[H] = for {
    x <- arbitrary[A]
    h <- oneOf(const(empty), genHeap)
  } yield insert(x, h)
  implicit lazy val arbHeap: Arbitrary[H] = Arbitrary(genHeap)

  def toSeq(h: H): List[Int] = isEmpty(h) match {
    case true => Nil
    case false => findMin(h) :: toSeq(deleteMin(h))
  }

  def isSorted(xs: List[Int]) = xs.sorted == xs

  property("gen1") = forAll { (h: H) =>
    val m = if (isEmpty(h)) 0 else findMin(h)
    findMin(insert(m, h)) == m
  }

  property("gen2") = forAll { (x: Int, y: Int) =>
    findMin(insert(y, insert(x, empty))) == Math.min(x, y)
  }

  property("gen3") = forAll { (x: Int) =>
    isEmpty(deleteMin(insert(x, empty)))
  }

  property("gen4") = forAll { (h: H) =>
    isSorted(toSeq(h))
  }

  property("gen5") = forAll { (h1: H, h2: H) =>
    Math.min(findMin(h1), findMin(h2)) == findMin(meld(h1, h2))
  }

  property("gen6") = forAll { (h1: H, h2: H) =>
    val merge = meld(h1, h2)
    isSorted(toSeq(merge))
  }

  property("gen7") = forAll { (h1: H, h2: H) =>
    val merge = meld(h1, h2)
    toSeq(merge) == (toSeq(h1) ++ toSeq(h2)).sorted
  }
}
