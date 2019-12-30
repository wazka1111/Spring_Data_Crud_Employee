package com.darek.employee.CRUD_employee.dao;

import com.darek.employee.CRUD_employee.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
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
}
