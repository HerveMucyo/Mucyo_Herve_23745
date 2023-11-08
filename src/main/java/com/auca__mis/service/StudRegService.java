package com.auca__mis.service;

import com.auca__mis.model.StudentRegistration;

import java.util.List;
import java.util.UUID;

public interface StudRegService {
    public boolean createStudentRegistration(StudentRegistration registration);
    public List<StudentRegistration> registrationList();
    public boolean deleteStudentRegistration(StudentRegistration registration);
    public StudentRegistration studRegistrationById(UUID id);
    public List<StudentRegistration> getStudentBySemester(UUID id);

    List<StudentRegistration> getStudentBySemesterAndDepartment(UUID id, UUID id1);

}
