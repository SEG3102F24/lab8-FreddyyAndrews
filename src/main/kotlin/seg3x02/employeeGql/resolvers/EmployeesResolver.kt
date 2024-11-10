package seg3x02.employeeGql.resolvers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import seg3x02.employeeGql.entity.Employee
import seg3x02.employeeGql.repository.EmployeesRepository

@Controller
class EmployeesResolver {

    @Autowired private lateinit var employeeRepository: EmployeesRepository

    @QueryMapping
    fun employees(): List<Employee> {
        // Fetch all employees from the database
        return employeeRepository.findAll()
    }

    @MutationMapping
    fun newEmployee(@Argument("createEmployeeInput") createEmployeeInput: EmployeeInput): Employee {
        // Create a new Employee entity from the input
        val employee =
                Employee(
                        name = createEmployeeInput.name,
                        dateOfBirth = createEmployeeInput.dateOfBirth,
                        city = createEmployeeInput.city,
                        salary = createEmployeeInput.salary,
                        gender = createEmployeeInput.gender,
                        email = createEmployeeInput.email
                )

        // Save the new employee to the database
        return employeeRepository.save(employee)
    }
}
