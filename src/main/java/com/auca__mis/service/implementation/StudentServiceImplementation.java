package com.auca__mis.service.implementation;

import com.auca__mis.dao.StudentDao;
import com.auca__mis.model.Student;
import com.auca__mis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class StudentServiceImplementation implements StudentService {
    private StudentDao studentDao;
    @Autowired
    public StudentServiceImplementation(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void saveStudent(Student student) {
        this.studentDao.save(student);
    }

    @Override
    public Student getStudentById(UUID id) {
        Optional<Student>optional=studentDao.findById(id);

        return optional.orElse(null);
    }

    @Override
    public void deleteStudent(UUID id) {
        // Check if the semester exists
        if (!studentDao.existsById(id)) {
            throw new RuntimeException("Student not found for id: " + id);
        }

        studentDao.deleteById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    @Override
    public void updateStudent(Student student) {
    UUID stuUuid=student.getId();
if (stuUuid==null || !studentDao.existsById(stuUuid)){
    throw new RuntimeException("Student not found for id: "+stuUuid);
}
    }
}
