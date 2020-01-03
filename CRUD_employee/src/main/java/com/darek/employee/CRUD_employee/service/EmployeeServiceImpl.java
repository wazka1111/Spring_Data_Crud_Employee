package com.darek.employee.CRUD_employee.service;

import com.darek.employee.CRUD_employee.dao.EmployeeRepository;
import com.darek.employee.CRUD_employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        //dodanie metody, która zwraca wszystko posortowane według last name
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee=null;
        if (result.isPresent()) {
            employee=result.get();
        }
        return employee;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {

        employeeRepository.deleteById(id);
    }
}
