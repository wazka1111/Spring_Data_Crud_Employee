package com.darek.employee.CRUD_employee.service;

import com.darek.employee.CRUD_employee.dao.EmployeeDAO;
import com.darek.employee.CRUD_employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {

        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public void save(Employee employee) {
         employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void deleteEmployeeById(int id) {
        employeeDAO.deleteById(id);
    }
}
