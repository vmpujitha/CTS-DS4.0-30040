package controller;

import com.cts.microservices.model.Employee;
import com.cts.microservices.repository.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee employee;

    @BeforeEach
    public void setup() {
        employee = new Employee(null, "Test User", "test@cts.com", "Testing", 50000.0, "1234567890");
        employee = employeeRepository.save(employee);
    }

    @AfterEach
    public void tearDown() {
        employeeRepository.deleteAll();
    }

    @Test
    public void testGetAllEmployees() throws Exception {
        mockMvc.perform(get("/api/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(employee.getName())));
    }

    @Test
    public void testGetEmployeeById() throws Exception {
        mockMvc.perform(get("/api/employees/" + employee.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(employee.getName())))
                .andExpect(jsonPath("$.email", is(employee.getEmail())));
    }

    @Test
    public void testCreateEmployee() throws Exception {
        String newEmployeeJson = """
            {
                "name": "New Employee",
                "email": "new@cts.com",
                "department": "Development",
                "salary": 60000.0,
                "phoneNumber": "9876543210"
            }
            """;

        mockMvc.perform(post("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newEmployeeJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("New Employee")));
    }
}