package com.sw.lms.interfaces.courseInterfaces;

import com.sw.lms.model.Course;

public interface CourseUpdater {
    Course update(Course updatedCourse, Long id);

}
