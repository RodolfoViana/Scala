import java.nio.file.attribute.UserDefinedFileAttributeView

/**
 * Created by viana on 10/03/15.
 */
class PhoneBoook(val owner: User) {

  var contacts = List[User]()

  if (owner == null){
    throw new IllegalArgumentException("requirement failed: Phonebook owner cannot be null");
  }

  def addContact (user:User): Unit = {
    if (contacts.contains(user)){
      throw new IllegalArgumentException("requirement failed: Cannot add repeated contacts");
    } else if (user == null){
      throw new IllegalArgumentException("requirement failed: Contact cannot be null");
    } else {
      contacts = user :: contacts
    }

  }


  def addPhoneNumber(user:String, phone:Int): Unit = {

    if (contacts.find(_.name == user).get ==  null){
      throw new IllegalArgumentException("There is no user named andryw");
    } else {
      //findUser(contacts.find(_.name == user).get, phone)
      contacts.find(_.name == user).get.addPhone(phone)
    }
  }

  /*def findUser(user:User, phone: Int): Unit = user match {
    case Some => user.addPhone(phone)
    case None => throw new IllegalArgumentException("There is no user named andryw");
  }*/

  def findContact (user:String): List[User] = {
    var list = List[User]()

    if (user == null){
      throw new IllegalArgumentException ("requirement failed: Cannot search for a null user")
    }

    for (user <- contacts.toList){
      if (user.name.contains(user)){
        list =  user :: list
      }
    }
    list
  }

}


