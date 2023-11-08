package com.auca__mis.service;
import com.auca__mis.model.Semester;


import java.util.List;
import java.util.UUID;


public interface SemesterService {
    void saveSemester(Semester semester);
    Semester getSemesterById(UUID id);
    void deleteSemester(UUID id);
    List<Semester> getAllSemesters();
    void updateSemester(Semester semester);

}
