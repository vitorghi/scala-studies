package classes

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Random, Success}

object FutureTesting extends App {

  def getContentAsFuture(value: Int): Future[Int] = {
    Thread.sleep(1000)
    Future {
     Random.nextInt() + value
    }
  }

  def returnOptionalValue(): Option[Int] = {
    Some(5)
  }

  //getContentAsFuture(5).onComplete {
  //  case Success(value) => println(s"foi $value")
  //  case Failure(exception) => exception.printStackTrace()
  //}
  /*getContentAsFuture(5).onComplete(x => println(s"sei la e $x"))
  for(i <- getContentAsFuture(5)) yield println(i)

  println("final")

  returnOptionalValue() {
    case Some =>
  }*/

}
