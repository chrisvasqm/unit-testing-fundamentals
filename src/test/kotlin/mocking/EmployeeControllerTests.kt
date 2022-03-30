package mocking

import com.google.common.truth.Truth.assertThat
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class EmployeeControllerTests {

    private lateinit var dataSource: DataSource
    private lateinit var controller: EmployeeController

    @BeforeMethod
    fun setUp() {
        dataSource = mock()
        controller = EmployeeController(dataSource)
    }

    @Test
    fun remove_FoundEmployee_ReturnsRedirectResult() {
        val actual = controller.delete(1)

        assertThat(actual).isInstanceOf(RedirectResult::class.java)
    }

    @Test
    fun remove_FoundEmployee_DeletesEmployee() {
        val id = 1

        controller.delete(id)

        verify(dataSource).delete(id)
    }
}