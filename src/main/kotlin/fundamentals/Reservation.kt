package fundamentals

class Reservation {

    var madeBy: User? = null

    fun canBeCancelledBy(user: User): Boolean {
        if (user.isAdmin)
            return true

        if (user == madeBy)
            return true;

        return false
    }

}

class User(var isAdmin: Boolean = false)
