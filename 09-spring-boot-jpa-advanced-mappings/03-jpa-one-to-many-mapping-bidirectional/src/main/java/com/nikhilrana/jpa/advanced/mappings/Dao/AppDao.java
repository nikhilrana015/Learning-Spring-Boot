package com.nikhilrana.jpa.advanced.mappings.Dao;

import com.nikhilrana.jpa.advanced.mappings.entity.Course;
import com.nikhilrana.jpa.advanced.mappings.entity.Instructor;
import com.nikhilrana.jpa.advanced.mappings.entity.InstructorDetail;
import java.util.List;

public interface AppDao {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesWithInstructorId(int id);

    Instructor findInstructorWithCoursesUsingJoinFetch(int id);

    void update(Instructor instructor);

    void update(Course course);

    Course findCourseById(int id);

    void deleteCourseById(int id);

}
