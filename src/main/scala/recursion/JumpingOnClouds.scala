package recursion

import scala.annotation.tailrec

object JumpingOnClouds {

  def jumpingOnClouds(c: Array[Int]): Int = {

    @tailrec
    def loop(c: Array[Int], acc: Int = 0): Int = {
      val step = if (c.length > 2 && c(2) == 0) c.tail.tail else c.tail
      c match {
        case c if c.length == 0 => acc
        case c if c.length == 1 => loop(step, acc)
        case _ => loop(step, acc + 1)
      }
    }

    loop(c)

  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val c = stdin.readLine.split(" ").map(_.trim.toInt)

    val result = jumpingOnClouds(c)
    println("Total of jumps: " + result)
  }
}

