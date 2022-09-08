object LonelyInteger extends App {

  def lonelyinteger(a: Array[Int]): Int = {
    val grouped = a.toList.groupBy(x => x).find(x => x._2.length == 1)
    grouped.get._1
  }

  val arr = Array(1, 2, 3, 4, 3, 2, 1)

  println(lonelyinteger(arr))
}
