

object CeaserCipher extends App {

  val lowStart = 97
  val lowEnd = 122

  val upperStart = 65
  val upperEnd = 90

  def caesarCipher(s: String, k: Int): String = {
    s.toCharArray.map(x => SecretChar(x, k).encode).mkString
  }

  case class SecretChar(charr: Char, flip: Int) {
    def encode: Char = {
      if (!charr.isLetter) charr
      else if (charr.isUpper) charConverter(charr, flip, upperEnd, upperStart)
      else charConverter(charr, flip, lowEnd, lowStart)
    }.toChar

    private def charConverter(charVal: Int, flip: Int, end: Int, start: Int): Int = {
      val amountOfNumbers = end - start + 1
      val realFlip = flip % amountOfNumbers
      val realAfterConv = charVal + realFlip

      realAfterConv match {
        case _ if realAfterConv > end =>
          val overMod = (charVal + realFlip) - end
          start + overMod - 1
        case _ => charVal + realFlip

        case _ => realAfterConv
      }
    }
  }

}
