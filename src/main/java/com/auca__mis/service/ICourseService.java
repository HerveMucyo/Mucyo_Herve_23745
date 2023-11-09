package com.auca__mis.service;

import com.auca__mis.model.Course;

import java.util.List;
import java.util.UUID;

public interface ICourseService {
    boolean insertCourse(Course course);
     List<Course> courseList();
    boolean deleteCourse(Course course);
    Course courseById(UUID id);
}
