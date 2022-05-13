package com.Golub.school.service;

import com.Golub.school.entity.Course;
import com.Golub.school.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public Course findByIdcourse(int id) {
        return courseRepository.findCourseByIdcourse(id);
    }

    public List<Course> getAllCourse()
    {
        return courseRepository.findAll();
    }

    public Course findByName(String name) {
        return courseRepository.findCourseByName(name);
    }

    public List<Course> findAllByLanguage(String language) {
        return courseRepository.findAllByLanguage(language);
    }

    public void save(Course course)
    {
        courseRepository.save(course);
    }

    public void edit(Course course, int id) {
        Course currentCourse = findByIdcourse(id);
        currentCourse.setName(course.getName());
        currentCourse.setLanguage(course.getLanguage());
        currentCourse.setCost(course.getCost());
        currentCourse.setDateOfBegin(course.getDateOfBegin());
        currentCourse.setDateOfEnd(course.getDateOfEnd());
        currentCourse.setNumberofseats(course.getNumberofseats());
        save(currentCourse);
    }

    public void delete(Course course, int id) {
        delete(course, id);
    }
}
