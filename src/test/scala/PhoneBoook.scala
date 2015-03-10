/**
 * Created by viana on 10/03/15.
 */
class PhoneBoook(owner: User) {

  var contacts = List()

  def addContact (owner:User) = owner :: contacts

}


