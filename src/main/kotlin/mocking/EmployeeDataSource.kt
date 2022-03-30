package mocking

interface DataSource {
    fun delete(id: Int)
}

class EmployeeDataSource : DataSource {

    private val context = EmployeeContext()

    override fun delete(id: Int) {
        val employee = context.employees.find { it.id == id } ?: return
        context.employees.remove(employee)
        context.saveChanges()
    }

}

class EmployeeContext {
    val employees: MutableList<Employee> = mutableListOf(Employee(id = 1))

    fun saveChanges() {}
}

class Employee(val id: Int)