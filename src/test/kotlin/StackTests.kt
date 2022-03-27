import com.google.common.truth.Truth.*
import fundamentals.Stack
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import javax.naming.OperationNotSupportedException

class StackTests {

    private lateinit var stack: Stack<Int>

    @BeforeMethod
    fun setUp() {
        stack = Stack()
    }

    @Test
    fun count_WhenStackIsEmpty_ReturnsZero() {
        val actual = stack.count

        assertThat(actual).isEqualTo(0)
    }

    @Test
    fun push_WhenCalled_IncreasesCount() {
        stack.push(1)

        val actual = stack.count

        assertThat(actual).isEqualTo(1)
    }

    @Test
    fun pop_WhenCalled_DecreasesCountAndRemovesLastItem() {
        stack.push(1)
        stack.push(2)

        val removedItem = stack.pop()
        val updatedCount = stack.count

        assertThat(removedItem).isEqualTo(2)
        assertThat(updatedCount).isEqualTo(1)
    }

    @Test
    fun peek_WhenCalled_ReturnsLastItem() {
        stack.push(1)
        stack.push(2)

        val actual = stack.peek()

        assertThat(actual).isEqualTo(2)
    }

    @Test(expectedExceptions = [IllegalArgumentException::class])
    fun push_WhenItemIsNull_ThrowsIllegalArgumentException() {
        stack.push(null)
    }

    @Test(expectedExceptions = [OperationNotSupportedException::class])
    fun pop_WhenCountIsZero_ThrowsOperationNotSupportedException() {
        stack.pop()
    }

    @Test(expectedExceptions = [OperationNotSupportedException::class])
    fun peek_WhenCountIsZero_ThrowsOperationNotSupportedException() {
        stack.peek()
    }

}