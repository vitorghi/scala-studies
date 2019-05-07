package recursion

object NewtonSqrt extends App {

  def abs(x: Double): Double =
    if (x < 0) -x else x

  def sqrt(x: Double): Double = {

    def isCloseEnough(guess: Double) =
      abs(guess * guess - x) / x < 0.001

    def improve(guess: Double) =
      (guess + x / guess) / 2

    def sqrtIterator(guess: Double): Double =
      if (isCloseEnough(guess)) guess
      else sqrtIterator(improve(guess))

    sqrtIterator(1)
  }

  assert(Math.round(sqrt(9)) == 3)
  assert(Math.round(sqrt(25)) == 5)
}
