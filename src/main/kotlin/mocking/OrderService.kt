package mocking

class OrderService(private val storage: Storage) {

    fun placeOrder(order: Order): Int {
        val id = storage.store(order)

        // Some other code

        return id
    }

}

interface Storage {
    fun store(order: Order): Int
}

class Order
