object DiagonalDifference extends App {

  def diagonalDifference(arr: Array[Array[Int]]): Int = {
    val cubeSize = arr.length

    val fromLeft = for {
      x <- 0 until cubeSize
    } yield {
      arr(x)(x)
    }

    val fromRight = for {
      x <- 0 until cubeSize
      y = (cubeSize - 1) - x
    } yield {
      arr(x)(y)
    }

    Math.abs(fromRight.sum - fromLeft.sum)
  }

  val data = Array(
    //    Array(3),
    Array(1, 2, 5), // 02 // 00
    Array(3, 4, 5), // 11 // 11
    Array(2, 7, 8), // 20 // 22
  )

  println(diagonalDifference(data))
}
