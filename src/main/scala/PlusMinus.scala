object PlusMinus extends App {

  def plusMinus(arr: Array[Int]) {

    val no = arr.length.toDouble
    val negative = arr.count(_ < 0) / no
    val postive = arr.count(_ > 0) / no
    val neutral = arr.count(_ == 0) / no

    println(negative)
    println(postive)
    println(neutral)
  }

  def miniMaxSum(arr: Array[Int]) {
    val longArr = arr.map(_.toLong)
    val max = longArr.sorted.drop(1).sum
    val min = longArr.sorted.reverse.drop(1).sum

    println(s"$min $max")
  }

  def findMedian(arr: Array[Int]): Double = {
    val sortedArr = arr.sorted.toList
    val middleValue = arr.length / 2
    val isEven = arr.length % 2 == 0
    if (isEven) (sortedArr(middleValue) + sortedArr(middleValue + 1)) / 2.0
    else sortedArr(middleValue)
  }

  def findOneMode[T](arr: Array[T]): T = {
    arr.groupBy(number => number)
      .map(group => Frequency(group._1, group._2.length))
      .maxBy(_.times)
      .number
  }

  def findAllModes[T](arr: Array[T]): List[T] = {
    val group = arr.groupBy(number => number)
      .map(group => Frequency(group._1, group._2.length))
    val freq = group.maxBy(_.times).times

    group.filter(_.times == freq).map(_.number).toList
  }

  case class Frequency[T](number: T, times: Int)


  //  val median = Array(6, 5, 3, 1, 2, 4)
  //  val median = Array(5, 3, 1, 2, 4, 4)
  val median = Array("A", "A", "B", "C", "C")
  val array = Array(1, 2, 3, 0, -1, -2, -3)
  val array1 = Array(1, 3, 5, 7, 9)
  val array2 = Array(256741038, 623958417, 467905213, 714532089, 938071625)

  //  plusMinus(array)
  //  miniMaxSum(array2)
  //  println(findMedian(median))
  println(findOneMode(median))
  println(findAllModes(median))
}
