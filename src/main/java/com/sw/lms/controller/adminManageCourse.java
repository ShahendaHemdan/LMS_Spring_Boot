package com.sw.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sw.lms.interfaces.courseInterfaces.CourseDeleter;
import com.sw.lms.interfaces.courseInterfaces.CourseRetriever;
import com.sw.lms.interfaces.courseInterfaces.CourseSaver;
import com.sw.lms.interfaces.courseInterfaces.CourseUpdater;
import com.sw.lms.model.Course;
import com.sw.lms.services.adminManageCourseService;

@RestController
@RequestMapping("/admin")
public class adminManageCourse {
    @Autowired
    private CourseRetriever courseRetriever;

    @Autowired
    private CourseDeleter courseDeleter;

    @Autowired
    private CourseUpdater courseUpdater;

    @Autowired
    private CourseSaver courseSaver;
    @Autowired
    private adminManageCourseService adminManageCourseService;

    @GetMapping("/allCourses")
    public List<Course> findAll() {
        return adminManageCourseService.findAll();
    }

    @GetMapping("/findCourse/{id}")
    public Course findById(@PathVariable Long id) {
        return courseRetriever.findById(id);
    }

    @DeleteMapping("/deleteCourse/{id}")
    public String deleteById(@PathVariable Long id) {
        courseDeleter.deleteById(id);
        return " Course with id: " + id + " deleted from the database";
    }

    @PostMapping("/addCourse")
    public String save(@RequestBody Course course) {
        return courseSaver.save(course) + " Course saved successfully";
    }

    @PutMapping("/updateCourse/{id}")
    public String update(@RequestBody Course course, @PathVariable Long id) {
        return courseUpdater.update(course, id) + " Course updated successfully";
    }

}
