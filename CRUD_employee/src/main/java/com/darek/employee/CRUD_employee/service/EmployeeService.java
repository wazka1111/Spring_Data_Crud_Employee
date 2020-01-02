package com.darek.employee.CRUD_employee.service;

import com.darek.employee.CRUD_employee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();

    public Employee findById(int id);

    public void save(Employee employee);

    public void deleteById(int id);

}
