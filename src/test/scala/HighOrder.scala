import scala.collection.immutable.HashMap

/**
 * Created by viana on 13/03/15.
 */
class HighOrder {
  def merge[A](ints: List[A], ints1: List[A], function: (A, A) => A): List[A] = {
    require(ints.size == ints1.size, "Lists must have the same size")
    require(!ints.isEmpty | !ints.isEmpty, "Lists are empty")

    var resp_list : List[A] = List[A]()

    resp_list = loop(ints, ints1, function, resp_list).reverse
    resp_list
  }

  def loop[A](ints: List[A], ints1: List[A], function: (A, A) => A, resp_list : List[A]): List[A] = {
    var aux_List: List[A] = resp_list

    if (!ints.isEmpty){
      aux_List :::= List(function(ints.head, ints1.head))
      loop(ints.tail, ints1.tail, function: (A, A) => A, aux_List)
    } else {
      aux_List
    }
  }

  //High Order functions list
  var myList = List[Int]()

  def addHead(item: Int): List[Int] = {
    myList = item :: myList
    myList
  }

  def addTail(item: Int): List[Int] = {
    myList = myList :+ item
    myList
  }

  def removeItem(item: Int): List[Int] = {
    myList = myList.filterNot(_ == item)
    myList
  }

  def replaceItem(item: Int, newItem: Int): List[Int] = {
    var list = List[Int]()
    var i = 0

    for (i <- myList){
      if (i != item){
        list = list :+ i
      } else {
        list = list :+ newItem
      }
      myList = list
    }
    myList
  }

  //High Order functions HashMap
  /*var myHash = HashMap[String, Int]()

  def addHash(key : String, value: Int): HashMap[String, Int] = {
    myHash.++:()
    myHash.++()
  }*/

}
