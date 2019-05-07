package recursion

import scala.annotation.tailrec

object TailRecSum extends App {

  def sum(f: Int => Int, a: Int, b: Int): Int = {

    @tailrec
    def loop(a: Int, acc: Int = 0): Int =
      if (a > b) acc
      else loop(a + 1, f(a) + acc)

    loop(a)
  }

  assert(sum(x => x, 1, 5) == 15)
  assert(sum(x => x * x, 1, 5) == 55)
}
