package com.nikhilrana.jpa.advanced.mappings.Dao;

import com.nikhilrana.jpa.advanced.mappings.entity.Instructor;
import com.nikhilrana.jpa.advanced.mappings.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;

@Repository
public class AppDaoImpl implements AppDao {

    private EntityManager entityManager;

    @Autowired
    public AppDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
        return instructorDetail;
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
       InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);

       instructorDetail.getInstructor().setInstructorDetail(null);

       entityManager.remove(instructorDetail);
    }
}
