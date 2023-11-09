package com.auca__mis.service.implementation;

import com.auca__mis.dao.TeacherDao;
import com.auca__mis.model.Teacher;
import com.auca__mis.service.ITeacherService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ITeacherServiceImplementation implements ITeacherService {
    private TeacherDao teacherDao;

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return this.teacherDao.save(teacher);
    }

    @Override
    public Teacher getTeacherById(Teacher teacher) {
        return this.teacherDao.findById(teacher.getId())
                .orElseThrow(() -> new RuntimeException("Teacher not found with code: " + teacher.getCode()));
    }

    @Override
    public void deleteTeacherById(Teacher teacher) {
        if (!this.teacherDao.existsById(teacher.getId())) {
            throw new RuntimeException("Teacher of id: " + teacher.getId() + "does not exit");
        } else {
            teacherDao.deleteById(teacher.getId());
        }
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return this.teacherDao.findAll();
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        Teacher updatedTeacher = this.teacherDao.findById(teacher.getId())
                .orElseThrow(() -> new RuntimeException("Teacher not found with code: " + teacher.getCode()));

        updatedTeacher.setCode(teacher.getCode());
        updatedTeacher.setName(teacher.getName());
        updatedTeacher.setQualification(teacher.getQualification());
        updatedTeacher.setCourseList(teacher.getCourseList());
        return this.teacherDao.save(updatedTeacher);
    }
}
