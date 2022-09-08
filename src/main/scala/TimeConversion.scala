object TimeConversion extends App {

  def timeConversion(s: String): String = {

    s.split(":").toList match {
      case hoursRaw :: min :: secsRaw :: Nil =>
        val pmOrAm = secsRaw.takeRight(2)
        val sec = secsRaw.dropRight(2)

        pmOrAm match {
          case "PM" =>
            hoursRaw match {
              case "12" => s"$hoursRaw:$min:$sec"
              case _ => s"${hoursRaw.toInt + 12}:$min:$sec"

            }
          case "AM" =>
            hoursRaw match {
              case "12" => s"00:$min:$sec"
              case _ => s"$hoursRaw:$min:$sec"
            }

          case _ => throw new Exception("KAKAO ALARM!")
        }
      case _ => throw new Exception(("EERRO!"))
    }
  }

  //  val input = "07:05:45PM"
  val input = "06:40:03AM"
  //  val input = "12:05:45AM"
  //  19:05:45

  println(timeConversion(input))
}
