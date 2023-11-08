package com.auca__mis.service;

import com.auca__mis.model.CourseDefinition;
import com.auca__mis.model.Semester;

import java.util.List;
import java.util.UUID;

public interface CourseDefinitionService {
    void saveCourseDef(CourseDefinition courseDefinition);
    CourseDefinition getCourseDefById(UUID id);
    void deleteCourseById(UUID id);
    List<CourseDefinition> getAllCourseDefs();
    void updateCourseDef(CourseDefinition courseDefinition);
}
