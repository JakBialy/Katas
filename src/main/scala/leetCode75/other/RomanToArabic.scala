package leetCode75.other

import java.time.Instant

object RomanToArabic extends App {

  def romanToInt(s: String): Int = {

    val romanToInt = Map("I" -> 1, "V" -> 5, "X" -> 10, "L" -> 50, "C" -> 100, "D" -> 500, "M" -> 1000)
    val romanToIntExtra = Map("IV" -> 4, "IX" -> 9, "XL" -> 40, "XC" -> 90, "CD" -> 400, "CM" -> 900)

    val clean = romanToIntExtra.keys.fold(s) { (accumulator, stringToRemove) =>
      accumulator.replaceAll(stringToRemove, "")
    }

    val weirdValues = s.toList.sliding(2, 1).map {
      case x :: xs :: Nil =>
        val maybeTogether = x.toString + xs.toString
        val romanValue = romanToIntExtra.getOrElse(maybeTogether, 0)
        romanValue
      case _ => 0
    }.sum

    val regulars = clean.map(x => romanToInt.getOrElse(x.toString, 0)).sum

    weirdValues + regulars
  }

  val roman = "MCMXCIV"
  //  Output: 1994

  println(romanToInt(roman))


  // s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
}
