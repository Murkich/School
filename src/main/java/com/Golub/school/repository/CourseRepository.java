package com.Golub.school.repository;

import com.Golub.school.entity.Course;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository <Course,Long> {

    Course findCourseByIdcourse(int id);
    Course findCourseByName(String name);
    List<Course> findAllByLanguage(String language);
}
