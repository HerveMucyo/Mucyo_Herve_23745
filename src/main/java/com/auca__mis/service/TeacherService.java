package com.auca__mis.service;

import com.auca__mis.model.Semester;
import com.auca__mis.model.Teacher;

import java.util.List;
import java.util.UUID;

public interface TeacherService {
    void saveTeacher(Teacher teacher);
    Teacher getTeacherById(UUID id);
    void deleteTeacherById(UUID id);
    List<Teacher> getAllTeachers();
    void updateTeacher(Teacher teacher);
}
