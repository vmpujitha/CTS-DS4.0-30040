package com.cts.microservices.services;

import com.cts.microservices.model.Employee;
import com.cts.microservices.repository.EmployeeRepository;
import com.cts.microservices.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    private Employee employee1;
    private Employee employee2;

    @BeforeEach
    public void setUp() {
        employee1 = new Employee(1L, "John Doe", "john@cts.com", "IT", 75000.0, "1234567890");
        employee2 = new Employee(2L, "Jane Smith", "jane@cts.com", "HR", 65000.0, "9876543210");
    }

    @Test
    public void testGetAllEmployees() {
        when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee1, employee2));

        List<Employee> employees = employeeService.getAllEmployees();

        assertEquals(2, employees.size());
        verify(employeeRepository, times(1)).findAll();
    }

    @Test
    public void testGetEmployeeById() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee1));

        Optional<Employee> foundEmployee = employeeService.getEmployeeById(1L);

        assertTrue(foundEmployee.isPresent());
        assertEquals("John Doe", foundEmployee.get().getName());
    }

    @Test
    public void testCreateEmployee() {
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee1);

        Employee createdEmployee = employeeService.createEmployee(employee1);

        assertNotNull(createdEmployee);
        assertEquals("John Doe", createdEmployee.getName());
    }
}