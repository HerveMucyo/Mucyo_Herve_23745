package com.auca__mis.service;


import com.auca__mis.model.Student;

import java.util.List;
import java.util.UUID;

public interface IStudentService {
    Student saveStudent(Student student);
    Student getStudentById(Student student);
    void deleteStudent(Student student);
    List<Student> getAllStudents();
    Student updateStudent(Student student);
}
