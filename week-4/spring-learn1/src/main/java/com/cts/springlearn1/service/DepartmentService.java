package com.cts.springlearn1.service;

import com.cts.springlearn1.dao.DepartmentDao;
import com.cts.springlearn1.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    public List<Department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }
}