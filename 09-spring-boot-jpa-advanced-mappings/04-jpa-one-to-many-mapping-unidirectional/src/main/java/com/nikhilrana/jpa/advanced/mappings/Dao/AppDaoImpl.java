package com.nikhilrana.jpa.advanced.mappings.Dao;

import com.nikhilrana.jpa.advanced.mappings.entity.Course;
import com.nikhilrana.jpa.advanced.mappings.entity.Instructor;
import com.nikhilrana.jpa.advanced.mappings.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class AppDaoImpl implements AppDao {

    private EntityManager entityManager;

    @Autowired
    public AppDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // persist is used to add object in database
    // Save and persist both used to save the object or data in table
    // READ-MORE: https://www.baeldung.com/hibernate-save-persist-update-merge-saveorupdate
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
        List<Course>courses = instructor.getCourses();

        /*
            Breaking the association because we don't do the cascading.
            So if we delete the instructor we have to remove the instructor-id
            from courses table otherwise we have stale data present in our id.
         */
        for(Course course: courses) {
            course.setInstructor(null);
        }

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

    @Override
    public List<Course> findCoursesWithInstructorId(int id) {

        TypedQuery<Course>theQuery = entityManager.createQuery("from Course where instructor.id=:data", Course.class);
        theQuery.setParameter("data", id);

        List<Course>courses = theQuery.getResultList();

        return courses;
    }


    /*
        Join fetch basically used to fetch courses eager manner using query method.
        Their primary usage is for fetching lazy-loaded associations eagerly for the current query.
        READ-MORE: https://www.baeldung.com/jpa-join-types
     */

    @Override
    public Instructor findInstructorWithCoursesUsingJoinFetch(int id) {
        TypedQuery<Instructor>theQuery = entityManager.createQuery(
                "select i from Instructor i JOIN FETCH i.courses JOIN FETCH i.instructorDetail where i.id = :data",
                Instructor.class
        );

        theQuery.setParameter("data", id);

        Instructor instructor = theQuery.getSingleResult();

        return instructor;
    }

    // merge is used to update the object
    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {

        Course courseToDelete = entityManager.find(Course.class, id);
        entityManager.remove(courseToDelete);
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int id) {

        TypedQuery<Course>query = entityManager.createQuery(
                "Select c from Course c JOIN FETCH c.reviews where c.id=:data",
                Course.class);

        query.setParameter("data", id);
        Course course = query.getSingleResult();

        return course;
    }
}
