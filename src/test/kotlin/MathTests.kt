import com.google.common.truth.Truth.assertThat
import fundamentals.Math
import org.testng.annotations.Test

class MathTests {

    @Test
    fun add_OnePlusTwo_ReturnsThree() {
        val math = Math()

        val actual = math.add(1, 2)

        assertThat(actual).isEqualTo(3)
    }

}