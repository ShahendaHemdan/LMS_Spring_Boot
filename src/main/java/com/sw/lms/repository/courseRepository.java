package com.sw.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sw.lms.model.Course;

public interface courseRepository extends JpaRepository<Course, Long> {

}
