package com.darek.employee.CRUD_employee.dao;

import com.darek.employee.CRUD_employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        Query query = entityManager.createQuery("from Employee");
        List <Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void save(Employee theEmployee) {
    Employee dbEmployee = entityManager.merge(theEmployee);
    theEmployee.setId(dbEmployee.getId());

    }

    @Override
    public void deleteById(int id) {
    Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
    query.setParameter("employeeId", id);
    query.executeUpdate();
    }
}
