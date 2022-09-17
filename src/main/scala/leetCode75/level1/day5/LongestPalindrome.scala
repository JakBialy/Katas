package leetCode75.level1.day5

object LongestPalindrome extends App {

  def longestPalindrome(s: String): Int = {
    val grouped = s.groupBy(x => x).map(x => x._2.length)
    val (even, odd) = grouped.partition(_ % 2 == 0)

    val evenAfterSubtracting = odd.map(_ - 1)
    (even ++ evenAfterSubtracting).sum + (if (odd.nonEmpty) 1 else 0)
  }

  val inp = "a"
  println(longestPalindrome(inp))
}
