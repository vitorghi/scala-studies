package recursion

import scala.annotation.tailrec

object ParenthesesBalancing extends App {

  def balance(chars: List[Char]): Boolean = {

    @tailrec
    def charsIterator(evaluatedChars: List[Char], openFound: Int = 0, closedFound: Int = 0): Boolean = {

      if (evaluatedChars.isEmpty && openFound == closedFound) true
      else evaluatedChars.head match {
        case x if x == ')' && closedFound >= openFound => false
        case x if x == '(' && evaluatedChars.tail.isEmpty => false
        case x if x == '(' => charsIterator(evaluatedChars.tail, openFound + 1, closedFound)
        case x if x == ')' => charsIterator(evaluatedChars.tail, openFound, closedFound + 1)
        case _ => charsIterator(evaluatedChars.tail, openFound, closedFound)
      }
    }

    charsIterator(chars)
  }

  assert(balance("()".toList))
  assert(balance("(just an) example".toList))
  assert(balance("(if (zero? x) max (/ 1 x))".toList))
  assert(balance("?".toList))

  assert(!balance("(just an)) example".toList))
  assert(!balance("())(".toList))
  assert(!balance("(".toList))
  assert(!balance(")".toList))
  assert(!balance(":-)".toList))
}
