package fundamentals

import com.google.common.truth.Truth.assertThat
import fundamentals.DemeritPointsCalculator
import org.testng.annotations.BeforeMethod
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

class DemeritPointsCalculatorTests {
    private lateinit var calculator: DemeritPointsCalculator

    @BeforeMethod
    fun setUp() {
        calculator = DemeritPointsCalculator()
    }

    @Test(expectedExceptions = [IllegalArgumentException::class], dataProvider = "under_and_upper_limits")
    fun calculateDemeritPoints_SpeedExceedsUnderOrUpperLimit_ThrowsIllegalArgumentException(limit: Int) {
        calculator.calculateDemeritPoints(limit)
    }

    @DataProvider(name = "under_and_upper_limits")
    private fun provideUnderAndUpperLimits(): Iterator<Int> {
        return listOf(-1, 301).iterator()
    }

    @Test(dataProvider = "speed_values")
    fun calculateDemeritPoints_WhenCalled_ReturnsDemeritPoints(speed: Int, expected: Int) {
        val actual = calculator.calculateDemeritPoints(speed)

        assertThat(actual).isEqualTo(expected)
    }

    @DataProvider(name = "speed_values")
    private fun provideSpeedValues(): MutableIterator<Array<Int>> {
        val data: ArrayList<Array<Int>> = arrayListOf()

        // Each case represents a pair of speed and expected demerit points to be calculated
        val case1 = arrayOf(0, 0)
        val case2 = arrayOf(64, 0)
        val case3 = arrayOf(65, 0)
        val case4 = arrayOf(66, 0)
        val case5 = arrayOf(70, 1)
        val case6 = arrayOf(75, 2)

        data.add(case1)
        data.add(case2)
        data.add(case3)
        data.add(case4)
        data.add(case5)
        data.add(case6)

        return data.iterator()
    }

}