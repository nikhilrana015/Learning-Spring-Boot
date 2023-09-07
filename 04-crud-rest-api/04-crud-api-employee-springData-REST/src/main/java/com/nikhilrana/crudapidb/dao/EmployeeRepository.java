package com.nikhilrana.crudapidb.dao;

import com.nikhilrana.crudapidb.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    /*
        JPA Respository already contains the default CRUD operations.
        So let's suppose we have N number of classes then for every class
        we have to create Dao and DaoImpl files and write the same CRUD code
        for each of the class that is replication of code. So to prevent from
        duplication we inherit the JpaRepository interface providing the class and
        type of primaryKey for our class. So now we don't have to write any of the code
        related to CRUD

        In this no need to add @transactional annotation at the service level because
        it is handled by JPA repository

    */
}
