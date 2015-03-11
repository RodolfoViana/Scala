import java.nio.file.attribute.UserDefinedFileAttributeView

/**
 * Created by viana on 10/03/15.
 */
class PhoneBook(val owner: User) {

  require(owner != null, "requirement failed: Phonebook owner cannot be null")

  var contacts = List[User]()

    def addContact (user:User): Unit = {

    if (user == null){
      throw new IllegalArgumentException("requirement failed: Contact cannot be null");
    } else if (contacts.contains(user)){
      throw new IllegalArgumentException("requirement failed: Cannot add repeated contacts");
    } else {
      contacts = user :: contacts
    }
  }

  def addPhoneNumber(name:String, phone:Int): Unit = {
    contacts.find(_.name == name) match {
      case Some(user) => user.addPhone(phone)
      case None => throw new IllegalArgumentException(s"There is no user named $name");
    }
  }


  def findContact (name:String): List[User] = {
    require(name != null, "requirement failed: Cannot search for a null user")

    contacts.filter(_.name.toLowerCase().contains(name.toLowerCase())).sortBy(_.name)
  }
}

