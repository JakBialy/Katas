package leetCode75.level1.day1

object PivotIndex extends App {

  def pivotIndex(nums: Array[Int]): Int = {
    val sum = nums.sum
    if (nums.head == sum) return 0

    val accumulated = nums.scanLeft(0)(_ + _).drop(1)

    val found = accumulated.zipWithIndex.toList.sliding(2).find {
      case left :: current :: Nil =>
        val leftV = left._1
        val actualV = current._1 - leftV
        leftV == sum - leftV - actualV
      case _ => false
    }.map {
      case _ :: xs :: Nil => xs._2
      case _ => -1
    }

    found.getOrElse(-1)
  }


  //  [2,1,-1]
  println(pivotIndex(Array(2, 1, -1)))
  //    println(pivotIndex(Array(1, 7, 3, 6, 5, 6)))
  //  println(pivotIndex(Array(1, 2, 3)))
  //    println(pivotIndex(Array(-1, -1, -1, -1, -1)))
  //  println(pivotIndex(Array(1, 1, 1, 1, 1)))
  //  println(pivotIndex(Array(-1, -1, -1, -1, -1, -1)))
  //  println(pivotIndex(Array(-1, -1, -1, -1, -1, 0)))
}
