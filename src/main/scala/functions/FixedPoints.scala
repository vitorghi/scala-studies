package functions

object FixedPoints extends App {

  val tolerance = 0.0001

  def isCloseEnough(value: Double, targetValue: Double) =
    Math.abs((value - targetValue) / value) / value < tolerance

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }

    iterate(firstGuess)
  }

  fixedPoint(x => 1 + x / 2)(1)

  def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2

  def sqrt(x: Double) =
    fixedPoint(averageDamp(y => y + x / y))(1)

  sqrt(2)
}
