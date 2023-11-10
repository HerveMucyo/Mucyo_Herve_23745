package com.auca__mis.service.implementation;

import com.auca__mis.dao.StudentDao;
import com.auca__mis.model.Student;
import com.auca__mis.service.IStudentService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class IStudentServiceImplementation implements IStudentService {
    private StudentDao studentDao;



    @Override
    public Student saveStudent(Student student) {
        return this.studentDao.save(student);
    }

    @Override
    public Student getStudentById(Student student) {

        return this.studentDao.findById(student.getId())
                .orElseThrow(() ->
                        new RuntimeException("Student of ID: " + student.getRegNo() + "Not found"));
    }

    @Override
    public void deleteStudent(Student student) {
     if(!this.studentDao.existsById(student.getId())){
         throw new
                 RuntimeException("Student of ID:"
                 +student.getRegNo()+" not found");
     }else{
         studentDao.deleteById(student.getId());
     }
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    @Override
    public Student updateStudent(Student student) {
        Student updatedStudent = this.studentDao.findById(student.getId())
                .orElseThrow(() -> new RuntimeException("Teacher not found with code: " + student.getRegNo()));

        updatedStudent.setRegNo(student.getRegNo());
        updatedStudent.setFullNames(student.getFullNames());
        updatedStudent.setDob(student.getDob());
        updatedStudent.setStudentRegistrations(student.getStudentRegistrations());
        return this.studentDao.save(updatedStudent);
    }
}
