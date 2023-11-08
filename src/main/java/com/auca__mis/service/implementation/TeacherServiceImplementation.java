package com.auca__mis.service.implementation;

import com.auca__mis.dao.TeacherDao;
import com.auca__mis.model.Teacher;
import com.auca__mis.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class TeacherServiceImplementation implements TeacherService {
private TeacherDao teacherDao;
@Autowired
    public TeacherServiceImplementation(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public void saveTeacher(Teacher teacher) {
    this.teacherDao.save(teacher);
    }

    @Override
    public Teacher getTeacherById(UUID id) {
        Optional<Teacher>optional=teacherDao.findById(id);
    return optional.orElse(null);
    }

    @Override
    public void deleteTeacherById(UUID id) {
if(!teacherDao.existsById(id)){
    throw new RuntimeException("Teacher of id: "+id+"does not exit");
}
teacherDao.deleteById(id);
    }

    @Override
    public List<com.auca__mis.model.Teacher> getAllTeachers() {
        return teacherDao.findAll();
    }
    @Override
    public void updateTeacher(com.auca__mis.model.Teacher teacher) {
UUID uuid=teacher.getId();
if(uuid==null||!teacherDao.existsById(uuid)){
    throw new RuntimeException("Teacher not found in DB Id: ");
}
    }
}
