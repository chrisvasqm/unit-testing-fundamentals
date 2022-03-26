import com.google.common.truth.StringSubject
import com.google.common.truth.Truth.assertThat
import fundamentals.ErrorLogger
import org.testng.annotations.Test

class ErrorLoggerTests {

    @Test
    fun log_WhenCalled_SavesLastError() {
        val logger = ErrorLogger()
        logger.log("a")

        val actual = logger.lastError

        assertThat(actual).isNotNullOrEmpty()
    }
}

private fun StringSubject.isNotNullOrEmpty(): Boolean =
    javaClass.getDeclaredField("actual").let {
        it.isAccessible = true
        val value = it.toString()
        return@let !value.isNullOrEmpty()
    }