package com.nikhilrana.crudapidb.dao;

import com.nikhilrana.crudapidb.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Standard JPA Api
    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> typedQuery = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> allEmployees = typedQuery.getResultList();
        return allEmployees;
    }

    @Override
    public Employee findEmployeeById(Integer employeeId) {

//         *** Query Based Approach ***
//         TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee where id=:id", Employee.class);
//         theQuery.setParameter("id", employeeId);
//
//         Employee employee = theQuery.getSingleResult();

        Employee employee = entityManager.find(Employee.class, employeeId);

        return employee;
    }

    @Override
    public void deleteEmployeeById(Integer employeeId) {

//         *** Query Based Approach ***
//        TypedQuery<Employee> theQuery = entityManager.createQuery("Delete from Employee where id=:id", Employee.class);
//        theQuery.setParameter("id", employeeId);
//
//        Employee employee = theQuery.getSingleResult();

        Employee employee = entityManager.find(Employee.class, employeeId);
        entityManager.remove(employee);
    }

    @Override
    public Employee saveEmployee(Employee employee) {

        /*  merge function of entity manager works in a way:
            1) If id==0, then it will insert/save the employee as a new employee in db
            2) If id!=0, then it will update the employee in db
        */

        Employee updatedEmployee = entityManager.merge(employee);
        return updatedEmployee;
    }
}
