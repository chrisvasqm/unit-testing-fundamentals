package fundamentals

import com.google.common.truth.Truth.assertThat
import fundamentals.HtmlFormatter
import org.testng.annotations.Test

class HtmlFormatterTests {

    @Test
    fun formatAsBold_WhenCalled_ShouldEncloseStringWithStrongElement() {
        val formatter = HtmlFormatter()
        val content = "abc"
        val actual = formatter.formatAsBold(content)

        assertThat(actual).isEqualTo("<strong>$content</strong>")
    }

}