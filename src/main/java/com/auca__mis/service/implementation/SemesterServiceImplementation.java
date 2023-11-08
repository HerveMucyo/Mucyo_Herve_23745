package com.auca__mis.service.implementation;

import com.auca__mis.dao.SemesterDao;
import com.auca__mis.model.Semester;
import com.auca__mis.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SemesterServiceImplementation implements SemesterService {

    private SemesterDao semesterDao;
    @Autowired
    public SemesterServiceImplementation(SemesterDao semesterDao) {
        this.semesterDao = semesterDao;
    }

    @Override
    public void saveSemester(Semester semester) {
        semesterDao.save(semester);
    }

    @Override
    public Semester getSemesterById(UUID id) {
        Optional<Semester> optional = semesterDao.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void updateSemester(Semester semester) {
        // Check if the semester exists
        UUID semesterId = semester.getId();
        if (semesterId == null || !semesterDao.existsById(semesterId)) {
            throw new RuntimeException("Semester not found for id: " + semesterId);
        }

        semesterDao.save(semester);
    }

    @Override
    public void deleteSemester(UUID id) {
        // Check if the semester exists
        if (!semesterDao.existsById(id)) {
            throw new RuntimeException("Semester not found for id: " + id);
        }
        semesterDao.deleteById(id);
    }

    @Override
    public List<Semester> getAllSemesters() {
        return semesterDao.findAll();
    }
}
