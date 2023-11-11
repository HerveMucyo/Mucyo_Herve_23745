package com.auca__mis.service;
import com.auca__mis.model.Semester;


import java.util.List;
import java.util.UUID;


public interface ISemesterService {
    void saveSemester(Semester semester);
    Semester getSemesterById(Semester semester);
    void deleteSemester(Semester semester);
    List<Semester> getAllSemesters();
    Semester updateSemester(Semester semester);

}
