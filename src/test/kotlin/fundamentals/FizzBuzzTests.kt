package fundamentals

import com.google.common.truth.Truth.assertThat
import fundamentals.FizzBuzz
import org.testng.annotations.Test

class FizzBuzzTests {

    @Test
    fun getOutput_IsDivisibleByThreeAndFive_ReturnsFizzBuzz() {
        val actual = FizzBuzz.getOutput(15)

        assertThat(actual).isEqualTo("FizzBuzz")
    }

    @Test
    fun getOutput_IsDivisibleByThree_ReturnsFizz() {
        val actual = FizzBuzz.getOutput(3)

        assertThat(actual).isEqualTo("Fizz")
    }

    @Test
    fun getOutput_IsDivisibleByFive_ReturnsBuzz() {
        val actual = FizzBuzz.getOutput(5)

        assertThat(actual).isEqualTo("Buzz")
    }

    @Test
    fun getOutput_IsNeitherDivisibleByThreeNorFive_ReturnsSameNumber() {
        val number = 1
        val actual = FizzBuzz.getOutput(number)

        assertThat(actual).isEqualTo(number.toString())
    }

    @Test
    fun getOutput_IsNegative_ReturnsSameNumber() {
        val number = -3
        val actual = FizzBuzz.getOutput(number)

        assertThat(actual).isEqualTo(number.toString())
    }

}