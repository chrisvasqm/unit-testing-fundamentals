package fundamentals

class Reservation {

    var madeBy: User? = null

    fun canBeCancelledBy(user: User): Boolean {
        return user.isAdmin || user == madeBy
    }

}

class User(var isAdmin: Boolean = false)
