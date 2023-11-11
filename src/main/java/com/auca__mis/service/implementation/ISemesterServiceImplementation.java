package com.auca__mis.service.implementation;

import com.auca__mis.dao.ISemesterDao;
import com.auca__mis.model.Semester;
import com.auca__mis.service.ISemesterService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ISemesterServiceImplementation implements ISemesterService {

    private ISemesterDao semesterDao;


    @Override
    public void saveSemester(Semester semester) {
        semesterDao.save(semester);
    }

    @Override
    public Semester getSemesterById(Semester semester) {
   return semesterDao.findById(semester.getId()).orElseThrow(()->new RuntimeException("Semester not found"));
    }

    @Override
    public Semester updateSemester(Semester semester) {
        Semester updatedSemester = this.semesterDao.findById(semester.getId())
                .orElseThrow(() -> new RuntimeException("Semester of Id:" + semester.getId() + "Not found"));

        updatedSemester.setId(semester.getId());
        updatedSemester.setName(semester.getName());
        updatedSemester.setStartDate(semester.getStartDate());
        updatedSemester.setEndDate(semester.getEndDate());
        updatedSemester.setStudentRegistrations(semester.getStudentRegistrations());
        updatedSemester.setCourseList(semester.getCourseList());

        return semesterDao.save(updatedSemester);

    }

    @Override
    public void deleteSemester(Semester semester) {
        // Check if the semester exists
        if (!semesterDao.existsById(semester.getId())) {
            throw new RuntimeException("Semester not found for id: " + semester.getId());
        }else{
            semesterDao.deleteById(semester.getId());
        }
    }

    @Override
    public List<Semester> getAllSemesters() {
        return semesterDao.findAll();
    }
}
