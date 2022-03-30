package mocking

class EmployeeController(private val context: EmployeeContext) {

    fun delete(id: Int): ActionResult {
        val employee: Employee? = context.employees.find { it.id == id }
        employee.let {
            context.employees.remove(it)
            context.saveChanges()
        }

        return redirectToAction("employees")
    }

    private fun redirectToAction(action: String): ActionResult {
        return RedirectResult(action)
    }

}

open class ActionResult
class RedirectResult(private val action: String) : ActionResult()

class EmployeeContext {
    val employees: MutableList<Employee> = mutableListOf(Employee(id = 1))

    fun saveChanges() {}
}

class Employee(val id: Int)
