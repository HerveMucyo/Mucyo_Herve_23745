package com.auca__mis.service.implementation;

import com.auca__mis.dao.ICourseDefinitionDao;
import com.auca__mis.model.CourseDefinition;
import com.auca__mis.service.CourseDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class CourseDefServiceImplemet implements CourseDefinitionService {
   private ICourseDefinitionDao dao;
    @Autowired
    public CourseDefServiceImplemet(ICourseDefinitionDao courseDefinitionDao) {
        this.dao = courseDefinitionDao;
    }




    @Override
    public void saveCourseDef(CourseDefinition courseDefinition) {
       this.dao.save(courseDefinition);
    }

    @Override
    public CourseDefinition getCourseDefById(UUID id) {
        Optional<CourseDefinition>optional=dao.findById(id);

        return optional.orElse(null);
    }

    @Override
    public void deleteCourseById(UUID id) {
if(!dao.existsById(id)){
    throw new RuntimeException(" course def not found");
}
        dao.deleteById(id);
    }

    @Override
    public List<CourseDefinition> getAllCourseDefs() {
        return dao.findAll();
    }

    @Override
    public void updateCourseDef(CourseDefinition courseDefinition) {
        UUID uuid=courseDefinition.getId();
        if (uuid==null || !dao.existsById(uuid)){
            throw new RuntimeException("Student not found for id: "+uuid);
        }
        dao.save(courseDefinition);
    }

}
