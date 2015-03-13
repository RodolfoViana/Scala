/**
 * Created by viana on 12/03/15.
 */

import java.util

import org.scalatest._

import scala.collection.immutable.HashMap

class ScalaTests extends FlatSpec with Matchers {
  "high order functions" should "merge two lists" in {
    val merge = new HighOrder()

    val l1: List[Int] = 10 to 19 toList
    val l2: List[Int] = 30 to 39 toList

    val plus: List[Int] = merge.merge(l1, l2, (a: Int, b: Int) => a + b)
    plus shouldBe sorted
    plus should contain inOrderOnly(40, 42, 44, 46, 48, 50, 52, 54, 56, 58)

    val minus = merge.merge(l2, l1, (a: Int, b: Int) => a - b)
    minus shouldBe sorted
    minus should contain only (20)
    minus should have size 10

    val multiplication = merge.merge(l1, l2, (a: Int, b: Int) => a * b)
    multiplication should contain inOrderOnly(300, 341, 384, 429, 476, 525, 576, 629, 684, 741)

    val l3 = l1 map { _.toDouble }
    val l4 = l2 map { _.toDouble }
    val division = merge.merge(l3, l4, (a: Double, b: Double) => a / b)
    division should contain inOrderOnly(0.3333333333333333, 0.3548387096774194, 0.375, 0.3939393939393939, 0.4117647058823529, 0.42857142857142855, 0.4444444444444444, 0.4594594594594595, 0.47368421052631576, 0.48717948717948717)

    val stringList1 = List("Igle", "Ta", "An", "Ar", "Leo")
    val stringList2 = List("son", "les", "dryw", "thur", "nardo")

    val concatenation = merge.merge(stringList1, stringList2, (a: String, b: String) => a + b)
    concatenation should have size 5
    concatenation should contain inOrderOnly("Igleson", "Tales", "Andryw", "Arthur", "Leonardo")
  }


  "List functions" should "Add item in the head of the list" in {
    val hO = new HighOrder()

    var myList = List[Int]()

    myList shouldBe empty

    // Add item at the
    myList = hO addHead 10
    myList should have size 1
    myList.head shouldBe 10

    // Add item at the tail
    myList = hO addTail 12
    myList should have size 2
    myList should contain inOrderOnly(10, 12)

    myList = hO addTail 13
    myList = hO addTail 18
    myList = hO addHead 23
    myList should have size 5
    myList should contain inOrderOnly(23, 10, 12, 13, 18)

    // Remove item
    myList = hO removeItem 13
    myList should have size 4
    myList should contain inOrderOnly(23, 10, 12, 18)

    // Replace item
    myList = hO replaceItem (10, 2)
    myList should have size 4
    myList should contain inOrderOnly(23, 2, 12, 18)

    var myHash = HashMap[String, Int]()

    // Add key/value
    myHash should have size 0
    myHash = hO addHash ("Rodolfo",10)
    myHash should have size 1
    myHash should contain ("Rodolfo" -> 10)

    myHash = hO addHash ("Pedro",20)
    myHash should have size 2
    myHash should contain ("Pedro" -> 20)
    myHash should contain ("Rodolfo" -> 10)

    // Remove key/value
    myHash = hO removeHash ("Pedro")
    myHash should have size 1
    myHash should not contain ("Pedro" -> 20)

    myHash = hO removeHash ("Rodolfo")
    myHash should have size 0

    // Return the value from one key
    myHash = hO addHash ("Pedro",20)
    myHash = hO addHash ("Rodolfo",10)
    val value = hO getValue ("Rodolfo")
    value shouldBe 10

    // Tuple
    var t = ("Rodolfo", 10, 10+20)
    println (t)

    // Print second value
    println (t._2)

    // Replace first element
    t = ("Casa", t._2, t._3)
    println (t)


    //Range 100 ints
    val range = new Range(1,101,1)
    range should have size 100
    println(range)

    // Map
    var fc = new FunctionalCombination()
    var list2 = fc.modify(myList, (a: Int) => a * a)
    println (list2)

    // Filter _
    var list3: List[Int] = 1 to 10 toList

    list3 = fc.filter(list3)
    println (list3)

    // Filter function
    var list4: List[Int] = 1 to 10 toList

    list4 = fc.filter(list4, (a:Int) => a % 2 == 0)
    println (list4)

    //

  }
}