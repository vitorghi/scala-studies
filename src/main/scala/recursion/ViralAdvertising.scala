package recursion

import scala.annotation.tailrec

object ViralAdvertising {

  def viralAdvertising(days: Int): Int = {

    @tailrec
    def iterate(daysLeft: Int, persons: Int = 5, likesAcc: Int = 0): Int = {
      if (daysLeft == 0) return likesAcc

      val likesInDay = Math.floor(persons / 2).toInt
      iterate(daysLeft - 1, likesInDay * 3, likesAcc + likesInDay)
    }

    iterate(days)
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val days = stdin.readLine.trim.toInt

    val result = viralAdvertising(days)
    println(result)
  }
}
