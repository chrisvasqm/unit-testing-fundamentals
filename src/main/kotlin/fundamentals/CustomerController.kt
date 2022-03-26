package fundamentals

class CustomerController {

    fun getCustomer(id: Int): ActionResult {
        if (id == 0)
            return NotFound()

        return Ok()
    }

}

open class ActionResult
class NotFound : ActionResult()
class Ok : ActionResult()