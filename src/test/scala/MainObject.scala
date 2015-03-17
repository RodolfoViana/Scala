/**
 * Created by viana on 17/03/15.
 */



object MainObject {
  def main(args: Array[String]) {
    val pb = new PhoneBook(new User("Rodolfo"))
    pb addName "viana"

    val hO = new HighOrder()

    val l1: List[Int] = 10 to 19 toList
    val l2: List[Int] = 30 to 39 toList

    print(hO.merge(l1, l2))
    print(hO)
  }

  implicit def sum(ints:Int, ints2:Int):Int = ints + ints2


  implicit def userName(name: String): User ={
    val newUser = new User(name)
    newUser
  }
}