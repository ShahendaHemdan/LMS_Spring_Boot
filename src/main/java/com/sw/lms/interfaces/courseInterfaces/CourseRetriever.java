package com.sw.lms.interfaces.courseInterfaces;

import java.util.*;

import com.sw.lms.model.Course;

public interface CourseRetriever {
    List<Course> findAll();

    Course findById(Long id);
}
