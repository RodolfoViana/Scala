import java.nio.file.attribute.UserDefinedFileAttributeView

/**
 * Created by viana on 10/03/15.
 */
class PhoneBook(val owner: User) {

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

  def addPhoneNumber(name:String, phone:Int): Unit = {

    contacts.find(_.name == name) match {
      case Some(user) => user.addPhone(phone)
      case None => throw new IllegalArgumentException("There is no user named " + name);
    }
  }


  def findContact (name:String): List[User] = {

    if (name == null){
      throw new IllegalArgumentException("requirement failed: Cannot search for a null user");
    }

    contacts.filter(_.name.toLowerCase().contains(name.toLowerCase())).sortBy(_.name)
  }
}


