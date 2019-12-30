package com.darek.employee.CRUD_employee.dao;

import com.darek.employee.CRUD_employee.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();
}
