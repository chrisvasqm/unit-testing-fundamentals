package fundamentals

import com.google.common.truth.StringSubject
import com.google.common.truth.Truth.assertThat
import org.testng.annotations.BeforeMethod
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

class ErrorLoggerTests {
    private lateinit var logger: ErrorLogger

    @BeforeMethod
    fun setUp() {
        logger = ErrorLogger()
    }

    @Test
    fun log_WhenCalled_SavesLastError() {
        logger.log("a")

        val actual = logger.lastError

        assertThat(actual).isNotNullOrEmpty()
    }

    private fun StringSubject.isNotNullOrEmpty(): Boolean =
        javaClass.getDeclaredField("actual").let {
            it.isAccessible = true
            val value = it.toString()
            return@let !value.isNullOrEmpty()
        }

    @Test(expectedExceptions = [IllegalArgumentException::class], dataProvider = "illegal_arguments")
    fun log_ErrorIsNullOrEmpty_ThrowsIllegalArgumentException(argument: String?) {
        logger.log(argument)
    }

    @DataProvider(name = "illegal_arguments")
    private fun provideIllegalArguments(): MutableIterator<String?> =
        mutableListOf(null, "", " ").iterator()

}

