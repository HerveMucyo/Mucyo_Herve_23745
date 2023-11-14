package com.auca__mis.service.implementation;

import com.auca__mis.dao.ICourseDefinitionDao;
import com.auca__mis.model.CourseDefinition;
import com.auca__mis.service.ICourseDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class ICourseDefServiceImplemet implements ICourseDefinitionService {
   private ICourseDefinitionDao dao;
    @Autowired
    public ICourseDefServiceImplemet(ICourseDefinitionDao courseDefinitionDao) {
        this.dao = courseDefinitionDao;
    }




    @Override
    public CourseDefinition saveCourseDef(CourseDefinition courseDefinition) {
     return   this.dao.save(courseDefinition);
    }

    @Override
    public CourseDefinition getCourseDefById(CourseDefinition courseDefinition) {
        Optional<CourseDefinition>optional=dao.findById(courseDefinition.getId());

        return optional.orElse(null);
    }

    @Override
    public void deleteCourseById(CourseDefinition courseDefinition) {
if(!dao.existsById(courseDefinition.getId())){
    throw new RuntimeException(" course def not found");
}
        dao.deleteById(courseDefinition.getId());
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
