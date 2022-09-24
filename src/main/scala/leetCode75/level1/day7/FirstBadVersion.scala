package leetCode75.level1.day7

import scala.annotation.tailrec

object FirstBadVersion extends App {

  def firstBadVersionOpt(badVersion: Int): Int = {

    @tailrec
    def findIndex(startVersion: Int, endVersion: Int): Int = {
      if (startVersion >= endVersion) return startVersion
      val midpointIndex = findMidValue(startVersion, endVersion)
      val isBad = isBadVersion(midpointIndex)

      val (newStartIndex, newEndIndex) = findNewIndexes(startVersion, midpointIndex, endVersion, isBad)
      findIndex(newStartIndex, newEndIndex)
    }

    def findNewIndexes(startVersion: Int, midpointIndex: Int, endVersion: Int, isBad: Boolean) = {
      if (!isBad) (midpointIndex + 1, endVersion)
      else (startVersion, midpointIndex)
    }

    def findMidValue(startVersion: Int, endVersion: Int) = {
      val toAdd = (endVersion - startVersion) / 2
      val midpointIndex = startVersion + toAdd
      midpointIndex
    }

    findIndex(1, badVersion)
  }

  def firstBadVersionDoubleCall(badVersion: Int): Int = {

    @tailrec
    def findIndex(startVersion: Int, endVersion: Int): Int = {
      if (startVersion >= endVersion) return 1
      val midpointIndex = findMidValue(startVersion, endVersion)
      val isBad = isBadVersion(midpointIndex)

      if ((!isBad) == isBadVersion(midpointIndex + 1)) return midpointIndex + 1
      val (newStartIndex, newEndIndex) = findNewIndexes(startVersion, midpointIndex, endVersion, isBad)

      findIndex(newStartIndex, newEndIndex)
    }

    def findNewIndexes(startVersion: Int, midpointIndex: Int, endVersion: Int, isBad: Boolean) = {
      if (!isBad) (midpointIndex, endVersion)
      else (startVersion, midpointIndex)
    }

    def findMidValue(startVersion: Int, endVersion: Int) = {
      val toAdd = (endVersion - startVersion) / 2
      val midpointIndex = startVersion + toAdd
      midpointIndex
    }

    findIndex(1, badVersion)
  }

  def firstBadVersionBrute(n: Int): Int = {
    (0 to n).findLast(x => !isBadVersion(x)).map(_ + 1).getOrElse(0)
  }


  def isBadVersion(version: Int): Boolean = {
    //    if (version == 10) true
    //    else if (version == 11) true
    //    else if (version == 12) true
    //    else if (version == 13) true
    //    if (version == 1) true
    if (version == 3) true
    else if (version == 4) true
    else if (version == 5) true
    else false
  }

  //   10 is first bad one

  //  println(firstBadVersionBrute(12))
  println(firstBadVersion(5))

}
