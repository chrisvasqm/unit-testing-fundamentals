package mocking

import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class OrderServiceTest {

    private lateinit var storage: Storage
    private lateinit var service: OrderService

    @BeforeMethod
    fun setUp() {
        storage = mock()
        service = OrderService(storage)
    }

    @Test
    fun placeOrder_WhenCalled_StoresOrder() {
        val order = Order()

        service.placeOrder(order)

        verify(storage).store(order)
    }
}