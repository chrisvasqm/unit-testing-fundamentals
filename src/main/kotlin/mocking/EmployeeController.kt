package mocking

class EmployeeController(private val dataSource: DataSource) {

    fun delete(id: Int): ActionResult {
        dataSource.delete(id)

        return redirectToAction("employees")
    }

    private fun redirectToAction(action: String): ActionResult {
        return RedirectResult(action)
    }

}

open class ActionResult
class RedirectResult(private val action: String) : ActionResult()
