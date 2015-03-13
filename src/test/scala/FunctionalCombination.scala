/**
 * Created by viana on 13/03/15.
 */
class FunctionalCombination {
  def modify[A](list: List[A], function: (A) => A): List[A] = {
    var resp_list = list.map(function)
    resp_list
  }

  def filter(list:List[Int]) : List[Int] = {
    var resp = list.filter((_ % 2 == 0))
    resp
  }

  def filter(list:List[Int], function: (Int => Boolean) ): List[Int] = {
    var resp = list.filter(function)
    resp
  }
}
