package com.cts.springlearn1.dao;

import com.cts.springlearn1.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class EmployeeDao {
    private static final Logger LOGGER = Logger.getLogger(EmployeeDao.class.getName());
    private static List<Employee> EMPLOYEE_LIST;

    public EmployeeDao() {
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
            EMPLOYEE_LIST = context.getBean("employeeList", List.class);
            LOGGER.info("Successfully loaded employee data from XML");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error loading employee data from XML", e);
            throw new RuntimeException("Failed to initialize employee data", e);
        }
    }

    public List<Employee> getAllEmployees() {
        if (EMPLOYEE_LIST == null) {
            throw new IllegalStateException("Employee list not initialized");
        }
        return EMPLOYEE_LIST;
    }
}