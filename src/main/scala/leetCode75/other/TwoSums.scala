package leetCode75.other

import scala.annotation.tailrec

object TwoSums extends App {

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    findIt(nums, target)
  }

  @tailrec
  def findIt(nums: Array[Int], target: Int, index1: Int = 0, index2: Int = 1): Array[Int] = {
    val el1 = nums(index1)
    val el2 = nums(index2)

    if (el1 + el2 == target) return Array(index1, index2)

    val lenght = nums.length - 1
    val newIndex1 = if (index2 == lenght) index1 + 1 else index1
    val newIndex2 = if (index2 == lenght) newIndex1 + 1 else index2 + 1

    findIt(nums, target, newIndex1, newIndex2)
  }

  println(twoSum(Array(3, 2, 4, 8), 12).mkString("Array(", ", ", ")"))

}
