import scala.annotation.tailrec

object TowerBreaker extends App {

  def towerBreakers(towers: Int, height: Int): Int = {
    if (height == 0) return 1
    if (towers % 2 == 0) 1 else 2
  }


  println(towerBreakers(1, 4))



//  1st 4 -2 = 2
//  2nd 2 - 1 = 1
//  1st looses -> 2 wins
}
