package recursion

object PascalTriangle extends App {

  def pascal(c: Int, r: Int): Int = {
    if (c == r || c == 0) 1 else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  assert(pascal(1, 4) == 4)
  assert(pascal(1, 3) == 3)
}
