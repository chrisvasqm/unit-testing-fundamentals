import com.google.common.truth.Truth.assertThat
import fundamentals.Math
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class MathTests {
    private lateinit var math: Math

    @BeforeMethod
    fun setUp() {
        math = Math()
    }

    @Test
    fun add_OnePlusTwo_ReturnsThree() {
        val actual = math.add(1, 2)

        assertThat(actual).isEqualTo(3)
    }

    @Test
    fun max_FirstArgumentIsGreater_ReturnFirstArgument() {
        val actual = math.max(2, 1)

        assertThat(actual).isEqualTo(2)
    }

    @Test
    fun max_SecondArgumentIsGreater_ReturnSecondArgument() {
        val actual = math.max(1, 2)

        assertThat(actual).isEqualTo(2)
    }

    @Test
    fun max_BothArgumentsAreEqual_ReturnSameArgument() {
        val actual = math.max(1, 1)

        assertThat(actual).isEqualTo(1)
    }
}