package implicits

case class Name(first: String, last: String)
case class Age(age: Int)
case class Person(name: Name, age: Age)
case class Config(name: String, age: Int)


object Imperative {

  def readName(implicit config: Config) = {
    val parts = config.name.split(" ")
    require(parts.length >= 2)
    Name(parts(0), parts.tail.mkString(" "))
  }

  def readAge(implicit config: Config): Age = {
    val age = config.age
    require(age > 0)
    Age(age)
  }

  def readPerson(implicit config: Config): Option[Person] =
    try Some(Person(readName, readAge))
    catch { case ex: IllegalArgumentException => None }

  def main(args: Array[String]) = {
    println(readPerson(Config("John", 20)))
    println(readPerson(Config("Mutating", 25)))
  }

}

//object Configs {
//  type Configured[T] = implicit Config => T
//  def config: Configured[Config] = implicitly[Config]
//
//}