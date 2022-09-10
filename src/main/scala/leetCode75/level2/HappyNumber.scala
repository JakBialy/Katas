package leetCode75.level2

import scala.annotation.tailrec

object HappyNumber extends App {

  //  one with cycle detection
  def isHappyTailrecWithCycleDetection(n: Int): Boolean = {
    @tailrec
    def cycle(n: Int, loop: Int = 0, set: Set[Int]): Boolean = {
      if (loop == 200 || set.contains(n)) return false
      else if (n == 1) return true

      val newSet = set + n
      val numbers = toSingleDigitsAlt(n)
      println(numbers)
      val squarePowNumbers = numbers.map(Math.pow(_, 2).toInt).sum
      cycle(squarePowNumbers, loop + 1, newSet)
    }

    cycle(n, set = Set.empty)
  }

  def isHappyTailrec(n: Int): Boolean = {
    @tailrec
    def cycle(n: Int, loop: Int = 0): Boolean = {
      if (loop == 200) return false
      else if (n == 1) return true

      val numbers = toSingleDigitsAlt(n)
      val squarePowNumbers = numbers.map(Math.pow(_, 2).toInt).sum
      cycle(squarePowNumbers, loop + 1)
    }

    cycle(n)
  }

  private def toSingleDigits(n: Int) = {
    n.toString.map(_.asDigit)
  }

  @tailrec
  private def toSingleDigitsAlt(n: Int, acc: List[Int] = List.empty): List[Int] = {
    if (n == 0) return acc
    val number = n % 10
    val newNumber = n / 10
    toSingleDigitsAlt(newNumber, number :: acc)
  }


  println(isHappyTailrecWithCycleDetection(116))
  println(isHappyTailrecWithCycleDetection(82))
}
