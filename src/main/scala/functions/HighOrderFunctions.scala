package functions

import scala.annotation.tailrec

object HighOrderFunctions extends App {

  def sum(f: Int => Int, a: Int, b: Int): Int = {

    @tailrec
    def loop(a: Int, acc: Int = 0): Int =
      if (a > b) acc
      else loop(a + 1, f(a) + acc)

    loop(a)
  }

  def _fact(x: Int) = 1

  def sumInt(a: Int, b: Int): Int = sum(x => x, a, b)
  def sumCubes(a: Int, b: Int): Int = sum(x => x * x * x, a, b)
  def sumFactorials(a: Int, b: Int): Int = sum(_fact, a, b)

  // Rewriting sum to optimize param args.
  def sumOptimized(f: Int => Int): (Int, Int) => Int = {
    def sum(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sum(a + 1, b)
    sum
  }

  def sumIntOptimized: (Int, Int) => Int = sumOptimized(x => x)
  def sumCubesOptimized: (Int, Int) => Int = sumOptimized(x => x * x * x)
  def sumFactorialsOptimized: (Int, Int) => Int = sumOptimized(_fact)


  // Further improving sum method
  def sumImproved(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 0 else f(a) + sumImproved(f)(a + 1, b)
  }
  sumImproved(x => x * x * x)(1, 5)

  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1 else f(a) * product(f)(a + 1, b)
  }
}
