package com.sw.lms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw.lms.interfaces.courseInterfaces.CourseDeleter;
import com.sw.lms.interfaces.courseInterfaces.CourseRetriever;
import com.sw.lms.interfaces.courseInterfaces.CourseSaver;
import com.sw.lms.interfaces.courseInterfaces.CourseUpdater;
import com.sw.lms.model.Course;
import com.sw.lms.repository.courseRepository;

@Service
public class adminManageCourseService implements CourseRetriever, CourseDeleter, CourseUpdater, CourseSaver {
    @Autowired
    private courseRepository courseRepository;

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Course findById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.orElse(null);
    }

    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public Course update(Course updatedCourse, Long id) {
        Optional<Course> oldECourse = courseRepository.findById(id);
        if (oldECourse.isPresent()) {
            Course Course = oldECourse.get();
            // Course.setId(updatedCourse.getId());
            Course.setName(updatedCourse.getName());
            Course.setCode(updatedCourse.getCode());
            return courseRepository.save(Course);
        } else
            return null;
    }

}
