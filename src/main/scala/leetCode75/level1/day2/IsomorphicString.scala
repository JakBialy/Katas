package leetCode75.level1.day2

import scala.annotation.tailrec

object IsomorphicString extends App {

  def isIsomorphic(s: String, t: String): Boolean = {
    s.zip(t).foldLeft(Map.empty[Char, Char]) { (acc, y) =>
      val value = y._1
      val key = y._2

      val areValuesSameForSameKeys = if (acc.contains(key)) acc.get(key).contains(value) else true
      val valuesForOtherKeys = (acc.keys.toSet - key).flatMap(acc.get)
      val noOtherKeysContainsSameV = valuesForOtherKeys.toList.contains(value)

      if (!areValuesSameForSameKeys || noOtherKeysContainsSameV) return false

      acc + (key -> value)
    }
    true
  }

  //  seems to be slightly faster, and much less memory consuming (80%!)
  def isIsomorphicV2(s: String, t: String): Boolean = {
    @tailrec
    def isIsomorphicTailRec(zipped: List[(Char, Char)], acc: Map[Char, Char] = Map.empty): Boolean = {
      val (key, value) = zipped match {
        case head :: _ => head
        case _ => return true
      }

      val areValuesSameForSameKeys = if (acc.contains(key)) acc.get(key).contains(value) else true
      val valuesForOtherKeys = (acc.keys.toSet - key).flatMap(acc.get)
      val noOtherKeysContainsSameV = valuesForOtherKeys.toList.contains(value)

      if (!areValuesSameForSameKeys || noOtherKeysContainsSameV) return false

      isIsomorphicTailRec(zipped.drop(1), acc + (key -> value))
    }

    isIsomorphicTailRec(s.toCharArray.zip(t.toCharArray).toList)
  }


  //    val s = "egg"
  //    val t = "add"
  //      val s = "foo"
  //      val t = "bar"
  //  val s = "paper"
  //  val t = "title"
  //  val s = "bbbaaaba"
  //  val t = "aaabbbba"
  val s = "badc"
  val t = "baba"

  println(isIsomorphic(s, t))
  println(isIsomorphicV2(s, t))
}
