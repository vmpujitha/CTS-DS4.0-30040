package com.cts.springlearn1.dao;

import com.cts.springlearn1.model.Department;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class DepartmentDao {
    private static final Logger LOGGER = Logger.getLogger(DepartmentDao.class.getName());
    private static List<Department> DEPARTMENT_LIST;

    public DepartmentDao() {
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("department.xml");
            DEPARTMENT_LIST = context.getBean("departmentList", List.class);
            LOGGER.info("Successfully loaded department data from XML");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error loading department data from XML", e);
            throw new RuntimeException("Failed to initialize department data", e);
        }
    }

    public List<Department> getAllDepartments() {
        if (DEPARTMENT_LIST == null) {
            throw new IllegalStateException("Department list not initialized");
        }
        return DEPARTMENT_LIST;
    }
}