package com.auca__mis.service;


import com.auca__mis.model.Semester;
import com.auca__mis.model.Student;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    void saveStudent(Student student);
    Student getStudentById(UUID id);
    void deleteStudent(UUID id);
    List<Student> getAllStudents();
    void updateStudent(Student student);
}
