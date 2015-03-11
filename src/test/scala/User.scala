/**
 * Created by viana on 10/03/15.
 */
class User(var name: String) {
  var phones = List[Int]()

  def addPhone(phone:Int): Unit = {
    if (phones.contains(phone)){
      throw new IllegalArgumentException ("requirement failed: Cannot add repeated number to a contact")
    }else {
      phones = phone :: phones
    }
  }

}

