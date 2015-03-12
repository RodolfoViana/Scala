/**
 * Created by viana on 12/03/15.
 */
import org.scalatest._

class ScalaTests extends FlatSpec with Matchers {

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

  "high order functions" should "merge two lists" in {
    val l1: List[Int] = 10 to 19 toList
    val l2: List[Int] = 30 to 39 toList

    val plus: List[Int] = merge(l1, l2, (a: Int, b: Int) => a + b)
    plus shouldBe sorted
    plus should contain inOrderOnly(40, 42, 44, 46, 48, 50, 52, 54, 56, 58)

    val minus = merge(l2, l1, (a: Int, b: Int) => a - b)
    minus shouldBe sorted
    minus should contain only (20)
    minus should have size 10

    val multiplication = merge(l1, l2, (a: Int, b: Int) => a * b)
    multiplication should contain inOrderOnly(300, 341, 384, 429, 476, 525, 576, 629, 684, 741)

    val l3 = l1 map { _.toDouble }
    val l4 = l2 map { _.toDouble }
    val division = merge(l3, l4, (a: Double, b: Double) => a / b)
    division should contain inOrderOnly(0.3333333333333333, 0.3548387096774194, 0.375, 0.3939393939393939, 0.4117647058823529, 0.42857142857142855, 0.4444444444444444, 0.4594594594594595, 0.47368421052631576, 0.48717948717948717)

    val stringList1 = List("Igle", "Ta", "An", "Ar", "Leo")
    val stringList2 = List("son", "les", "dryw", "thur", "nardo")

    val concatenation = merge(stringList1, stringList2, (a: String, b: String) => a + b)
    concatenation should have size 5
    concatenation should contain inOrderOnly("Igleson", "Tales", "Andryw", "Arthur", "Leonardo")
  }
}