package fundamentals

class Reservation {

    var madeBy: User? = null

    fun canBeCancelledBy(user: User): Boolean = user.isAdmin || user == madeBy

}

class User(var isAdmin: Boolean = false)
