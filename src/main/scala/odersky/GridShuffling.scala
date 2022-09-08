package odersky

object GridShuffling extends App {

  def gridChallenge(grid: Array[String]): String = {
    val sorted = grid.map { row =>
      row.sorted
    }

    val columns = for {
      el <- 0 until sorted.head.length
      row <- sorted
    } yield {
      row(el)
    }

    val rowNumber = sorted.length

    val checkColumns = columns.toList.sliding(rowNumber, rowNumber).map { x =>
      val unsorted = x.mkString
      unsorted.sorted == unsorted
    }

    if (checkColumns.forall(x => x)) "YES"
    else "NO"
  }

  val arrays1 = Array(
    "abc",
    "hjk",
    "mpq",
    "rtv"
  )

  println(gridChallenge(arrays1))
}
