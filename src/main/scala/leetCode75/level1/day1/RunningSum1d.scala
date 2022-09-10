package leetCode75.level1.day1

object RunningSum1d extends App {

  def runningSum(nums: Array[Int]): Array[Int] = {
    nums.foldLeft(Array.empty[Int]) { (acc, value) =>
      acc :+ (value + acc.lastOption.getOrElse(0))
    }
  }

  def runningSumScan(nums: Array[Int]): Array[Int] = {
    nums.scan(0) {
      _ + _
    }.drop(1)
  }

  println(runningSum(Array(1, 2, 3, 4, 5)).mkString("Array(", ", ", ")"))
  println(runningSumScan(Array(1, 2, 3, 4, 5)).mkString("Array(", ", ", ")"))
}
