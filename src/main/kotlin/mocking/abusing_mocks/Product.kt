package mocking.abusing_mocks

class Product(val price: Float) {

    fun getPrice(customer: ICustomer): Float {
        if (customer.isGold)
            return price * 0.7f

        return price
    }

}

interface ICustomer {
    var isGold: Boolean
}

class Customer : ICustomer {
    override var isGold: Boolean = false
}
