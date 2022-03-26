import com.google.common.truth.Truth.assertThat
import fundamentals.CustomerController
import fundamentals.NotFound
import fundamentals.Ok
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class CustomerControllerTests {

    private lateinit var controller: CustomerController

    @BeforeMethod
    fun setUp() {
        controller = CustomerController()
    }

    @Test
    fun getCustomer_IdIsZero_ReturnsNotFoundResult() {
        val actual = controller.getCustomer(0)

        assertThat(actual).isInstanceOf(NotFound::class.java)
    }

    @Test
    fun getCustomer_IdIsNotZero_ReturnsOkResult() {
        val actual = controller.getCustomer(1)

        assertThat(actual).isInstanceOf(Ok::class.java)
    }

}