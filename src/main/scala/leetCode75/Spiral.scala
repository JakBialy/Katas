package leetCode75

import scala.annotation.tailrec

object Spiral {

  object SpiralMatrix extends App {

    def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
      val numberOfElements = matrix.length * matrix.head.length

      @tailrec
      def spiralMatrix(
                        toGo: Int = numberOfElements,
                        minY: Int = 0,
                        maxY: Int = matrix.length - 1,
                        minX: Int = 0,
                        maxX: Int = matrix.head.length - 1,
                        indexX: Direction = Right(0),
                        indexY: Direction = Right(0),
                        acc: List[Int] = List.empty
                      ): List[Int] = {
        if (matrix.head.length - 1 == 0) return matrix.flatten.toList
        if (toGo == 0) return acc

        val int = matrix(indexY.indexV)(indexX.indexV)
        println(int)

        val newX = figureOutNewIndexX(minY, maxY, minX, maxX, indexX.indexV, indexY.indexV)
        val newY = figureOutNewIndexY(minY, maxY, minX, maxX, indexX.indexV, indexY.indexV)

        //      detect movement down only once!

        //      when down reduce min Y by 1
        val changeToDown = detectDown(indexX, newX)
        val newMinY = if (changeToDown) minY + 1 else minY
        //      when left reduce max Y by 1
        val changeToLeft = detectLeft(indexX, newX)
        val newMaxX = if (changeToLeft) maxX - 1 else maxX
        //      when up reduce max Y by 1
        val changeToUp = detectUp(indexX, newX)
        val newMaxY = if (changeToUp) maxY - 1 else maxY
        //      when right reduce min X by 1
        val changeToRight = detectRight(indexX, newX)
        //      val goingRight = detectRight(indexX, newX)
        val justregularRight = detectRightMovement(indexX)
        val newMinX = if (changeToRight || ((minY == maxY) && justregularRight)) minX + 1 else minX
        //      val newMinX = if (changeToRight) minX + 1 else minX

        spiralMatrix(toGo - 1, newMinY, newMaxY, newMinX, newMaxX, newX, newY, acc.appended(int))
      }


      def figureOutNewIndexY(minY: Int, maxY: Int, minX: Int, maxX: Int, indexX: Int, indexY: Int): Direction = {
        //      right wall: going vertically down, cut the wall!
        //      if (isMinY(minY, indexY) && isMinX(minX, indexX)) Down(indexY - 1)
        if (!isMinY(minY, indexY) && isMinX(minX, indexX)) Up(indexY - 1)
        // bottom wall, going horizontally backwards
        //      else if (isMaxY(maxY, indexY) && minY != maxY) Left(indexY)
        else if (isMaxY(maxY, indexY) && !isMinX(minX, indexX) && (if (maxY == 0) false else true)) Left(indexY)
        //      else if (isMaxY(maxY, indexY) && !isMinX(minX, indexX) && minY != maxY) Left(indexY)
        //        left wall: going vertically up, cut the wall!
        else if (isMaxX(maxX, indexX)) Down(indexY + 1)
        //        upper wall: keeping same Y
        else Right(indexY)
      }

      def figureOutNewIndexX(minY: Int, maxY: Int, minX: Int, maxX: Int, indexX: Int, indexY: Int): Direction = {
        //      left wall: keep X, going vertically up
        if (!isMinY(minY, indexY) && isMinX(minX, indexX)) Up(indexX)
        //              bottom wall, go horizontally backward, cut the wall!
        //      else if (isMaxY(maxY, indexY) && minY != maxY) Left(indexX - 1)
        else if (isMaxY(maxY, indexY) && !isMinX(minX, indexX) && (if (maxY == 0) false else true)) Left(indexX - 1)
        //      else if (isMaxY(maxY, indexY) && !isMinX(minX, indexX) && minY != maxY) Left(indexX - 1)
        //        right wall, going vertically, down
        else if (isMaxX(maxX, indexX)) Down(indexX)
        //        upper wall: moving horizontally upward, cut the wall!
        else Right(indexX + 1)
      }

      spiralMatrix()
    }

    private def detectRight(indexX: Direction, newX: Direction) = {
      indexX match {
        case Up(_) => newX match {
          case Right(_) => true
          case _ => false
        }
        case _ => false
      }
    }

    private def detectRightMovement(indexX: Direction) = {
      indexX match {
        case Right(_) => true
        case _ => false
      }
    }

    private def detectUp(indexX: Direction, newX: Direction) = {
      indexX match {
        case Left(_) => newX match {
          case Up(_) => true
          case _ => false
        }
        case _ => false
      }
    }

    private def detectLeft(indexX: Direction, newX: Direction) = {
      indexX match {
        case Down(_) => newX match {
          case Left(_) => true
          case _ => false
        }
        case _ => false
      }
    }

    sealed abstract class Direction(val indexV: Int)

    case class Right(override val indexV: Int) extends Direction(indexV)

    case class Left(override val indexV: Int) extends Direction(indexV)

    case class Up(override val indexV: Int) extends Direction(indexV)

    case class Down(override val indexV: Int) extends Direction(indexV)


    private def detectDown(indexX: Direction, newX: Direction) = {
      indexX match {
        case Right(_) => newX match {
          case Down(_) => true
          case _ => false
        }
        case _ => false
      }
    }

    private def isMinY(min: Int, indexY: Int) = {
      indexY == min
    }

    private def isMinX(min: Int, indexX: Int) = {
      min == indexX
    }

    private def isMaxY(maxY: Int, indexY: Int) = {
      indexY == maxY
    }

    private def isMaxX(min: Int, indexX: Int) = {
      min == indexX
    }

    val input = Array(
      Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
      Array(11, 12, 13, 14, 15, 16, 17, 18, 19, 20),
      Array(21, 22, 23, 24, 25, 26, 27, 28, 29, 30),
      Array(31, 32, 33, 34, 35, 36, 37, 38, 39, 40),
      Array(41, 42, 43, 44, 45, 46, 47, 48, 49, 50),
    )

    val inputt = Array(
      Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
      Array(11, 12, 13, 14, 15, 16, 17, 18, 19, 20),
      Array(21, 22, 23, 24, 25, 26, 27, 28, 29, 30),
      Array(31, 32, 33, 34, 35, 36, 37, 38, 39, 40))

    val input2 = Array(Array(1, 2), Array(3, 4))
    //  val input3 = Array(Array(1, 2, 3, 4)
    //    , Array(3, 4, 5, 6),
    //    Array(6, 7, 8, 7))
    // 1 2
    // 3 4

    //        val input1 = Array(Array(1,2,3),Array(4,5,6),Array(7,8,9))
    //    val inp = Array(Array(6, 7, 8))
    //    [[1,2],[3,4]]
    val sss = Array(
      Array(1),
      Array(2),
      Array(3),
      Array(4),
      Array(5),
      Array(6),
      Array(7),
      Array(8),
      Array(9),
      Array(10),
    )

    println(spiralOrder(sss))

    //  println(spiralOrder(input2))

    /*
    Input: matrix = [[1 ,2,   3  ]
                    ,[4 ,5,   6  ]
                    ,[7 ,8 ,9 ]]
    Output: [1,2,3, 4, 8, 12, 11, 10, 9, 5, 6 ,7]

    https://leetcode.com/problems/spiral-matrix/
     */
  }


}

