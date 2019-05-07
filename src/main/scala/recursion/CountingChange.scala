package recursion

object CountingChange extends App {

  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (money > 0 && coins.nonEmpty)
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
    else 0
  }

  assert(countChange(4, List(1, 2)) == 3)

}
