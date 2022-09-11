package leetCode75.level1.day2

object IsomorphicString extends App {

  def isIsomorphic(s: String, t: String): Boolean = {
    s.zip(t).foldLeft(Map.empty[Char, Char]) { (acc, y) =>
      val value = y._1
      val key = y._2

      val areValuesSameForSameKeys = if (acc.contains(key)) acc.get(key).contains(value) else true
      //      different key can't have already existing value
      val getOtherValues = acc.keys.filterNot(_ == key).toSet.flatMap(acc.get)
      val noOtherKeysContainsSameV = getOtherValues.toList.contains(value)

      if (!areValuesSameForSameKeys || noOtherKeysContainsSameV) return false

      acc + (key -> value)
    }
    true
  }


  val s = "egg"
  val t = "add"
  //  val s = "foo"
  //  val t = "bar"
  //      val s = "paper"
  //      val t = "title"
  //        val s = "bbbaaaba"
  //        val t = "aaabbbba"
  //  val s = "badc"
  //  val t = "baba"

  println(isIsomorphic(s, t))
}
