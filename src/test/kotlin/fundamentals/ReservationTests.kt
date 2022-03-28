package fundamentals

import com.google.common.truth.Truth.*
import org.testng.annotations.Test

class ReservationTests {

    @Test
    fun canBeCancelledBy_AdminUser_ReturnsTrue() {
        val reservation = Reservation()

        val actual = reservation.canBeCancelledBy(User(isAdmin = true))

        assertThat(actual).isTrue()
    }

    @Test
    fun canBeCancelledBy_SameUser_ReturnsTrue() {
        val user = User()
        val reservation = Reservation().apply { madeBy = user }

        val actual = reservation.canBeCancelledBy(user)

        assertThat(actual).isTrue()
    }

    @Test
    fun canBeCancelledBy_AnotherUser_ReturnsFalse() {
        val reservation = Reservation().apply { madeBy = User() }

        val actual = reservation.canBeCancelledBy(User())

        assertThat(actual).isFalse()
    }

}