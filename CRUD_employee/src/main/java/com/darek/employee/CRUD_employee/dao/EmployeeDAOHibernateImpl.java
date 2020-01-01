package com.darek.employee.CRUD_employee.dao;

import com.darek.employee.CRUD_employee.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;

import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    //entitymanager
    private EntityManager entityManager;

    //constructor injection
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager=entityManager;
    }

    @Override
    public List<Employee> findAll() {
        //hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        //create query
        Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
        //get result list
        List<Employee> employees = query.getResultList();
        //return results
        return employees;
    }

    @Override
    public Employee findById(int id) {
        //get session
        Session currentSession = entityManager.unwrap(Session.class);
        //get employee
        Employee employee = currentSession.get(Employee.class, id);
        //return employee
        return employee;
    }

    @Override
    public void save(Employee employee) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(employee);
    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
