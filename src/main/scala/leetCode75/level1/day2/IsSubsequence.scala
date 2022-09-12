package leetCode75.level1.day2

import scala.annotation.tailrec

object IsSubsequence extends App {

  def isSubsequence(s: String, t: String): Boolean = {

    @tailrec
    def isSubRec(toFind: String, toScan: String): Boolean = {
      val scanIndex = toFind.toList match {
        case lookup :: _ =>
          val index = toScan.zipWithIndex.find(charWithIndex => charWithIndex._1 == lookup).map(_._2)
          index match {
            case Some(value) => value
            case None => return false
          }
        case _ => return true
      }

      isSubRec(toFind.drop(1), toScan.drop(scanIndex + 1))
    }

    isSubRec(s, t)
  }


  //  val s = "abc"
  //  val t = "ahbgdc"

  val s = "axc"
  val t = "ahbgdc"

  println(isSubsequence(s, t))
}
