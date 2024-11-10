package seg3x02.employeeGql.resolvers

data class EmployeeInput(
        val name: String,
        val dateOfBirth: String,
        val city: String,
        val salary: Float,
        val gender: String,
        val email: String
)
