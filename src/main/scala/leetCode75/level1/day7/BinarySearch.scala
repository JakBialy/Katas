package leetCode75.level1.day7

import scala.annotation.tailrec

object BinarySearch extends App {

  def search(nums: Array[Int], target: Int): Int = {

    @tailrec
    def findIndex(startIndex: Int, endIndex: Int): Int = {
      if (startIndex > endIndex) return -1

      val (midpointIndex, midpointVal) = findMidValue(nums, startIndex, endIndex)
      if (midpointVal == target) return midpointIndex
      val (newStartIndex, newEndIndex) = findNewIndexes(target, startIndex, endIndex, midpointIndex, midpointVal)

      findIndex(newStartIndex, newEndIndex)
    }

    def findNewIndexes(target: Int, startIndex: Int, endIndex: Int, midpointIndex: Int, midpointVal: Int) = {
      if (target > midpointVal) (midpointIndex + 1, endIndex)
      else (startIndex, midpointIndex - 1)
    }

    def findMidValue(nums: Array[Int], startIndex: Int, endIndex: Int) = {
      val toAdd = (endIndex - startIndex) / 2
      val midpointIndex = startIndex + toAdd

      val midpointVal = nums(midpointIndex)
      (midpointIndex, midpointVal)
    }

    findIndex(0, nums.length - 1)
  }


  //  val nums = Array(1, 2, 3, 4, 5, 6, 7, 8, 90, 101, 250, 333)
  //  val nums = Array(-1, 0, 3, 5, 9, 12)
  val nums = Array[Int](1)

  println(search(nums, 1))

}
