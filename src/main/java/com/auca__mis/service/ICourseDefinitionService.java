package com.auca__mis.service;

import com.auca__mis.model.CourseDefinition;

import java.util.List;
import java.util.UUID;

public interface ICourseDefinitionService {
    CourseDefinition saveCourseDef(CourseDefinition courseDefinition);
    CourseDefinition getCourseDefById(CourseDefinition courseDefinition);
    void deleteCourseById(UUID id);
    List<CourseDefinition> getAllCourseDefs();
    void updateCourseDef(CourseDefinition courseDefinition);
}
