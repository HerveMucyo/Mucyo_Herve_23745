package com.auca__mis.service;

import com.auca__mis.model.StudentRegistration;

import java.util.List;
import java.util.UUID;

public interface IStudRegService {
    StudentRegistration createStudentRegistration(StudentRegistration registration);
    List<StudentRegistration> registrationList();
    void deleteStudentRegistration(StudentRegistration registration);

//    List<StudentRegistration> getStudentBySemesterId(UUID id);

    List<StudentRegistration> getStudentBySemesterAndDepartment(UUID id, UUID unitId);

    List<StudentRegistration> getStudentBySemesterId(UUID id);
}
