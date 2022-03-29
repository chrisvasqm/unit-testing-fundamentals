package mocking.abusing_mocks

import com.google.common.truth.Truth.assertThat
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class ProductTests {

    private lateinit var product: Product

    @BeforeMethod
    fun setUp() {
        product = Product(10f)
    }

    @Test
    fun getPrice_GoldCustomer_Apply30PercentDiscount() {
        val customer = Customer().apply { isGold = true }

        val actual = product.getPrice(customer)

        assertThat(actual).isEqualTo(7)
    }

    @Test
    fun abusing_Mocks() {
        val customer: ICustomer = mock()
        whenever(customer.isGold).thenReturn(true)

        val actual = product.getPrice(customer)

        assertThat(actual).isEqualTo(7)
    }

}