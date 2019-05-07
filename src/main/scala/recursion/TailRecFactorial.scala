package recursion

import scala.annotation.tailrec

object TailRecFactorial extends App {

  def factorial(n: Int): Int =
    if (n == 0) 1 else n * factorial(n - 1)

  assert(factorial(4) == 24)
  assert(factorial(5) == 120)

  @tailrec
  def tailRecFactorial(n: Int, accumulator: Int = 1): Int =
    if (n == 0) accumulator else tailRecFactorial(n - 1, accumulator * n)

  assert(tailRecFactorial(4) == 24)
  assert(tailRecFactorial(5) == 120)
}
