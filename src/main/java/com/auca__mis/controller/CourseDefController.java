package com.auca__mis.controller;

import com.auca__mis.model.CourseDefinition;
import com.auca__mis.service.ICourseDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class CourseDefController {
    private final ICourseDefinitionService service;
    @Autowired
    public CourseDefController(ICourseDefinitionService service) {
        this.service = service;
    }


    @GetMapping("/courseDef")
    public String showCourseDefDashboard(Model model) {

        List<CourseDefinition> courseDefinitionList = service.getAllCourseDefs();
        model.addAttribute("courseDef",new CourseDefinition());
        model.addAttribute("courseDefinitionList", courseDefinitionList);
        return "CourseDefinition";

    }
    @PostMapping("/courseDef/create")
    public String createCourseDef(@ModelAttribute("courseDef") CourseDefinition courseDefinition, @Param("action") String action) {
      if(action.equals("Delete")){
          service.deleteCourseById(courseDefinition);
      }else if(action.equals("Update")){
          service.updateCourseDef(courseDefinition);
      }else{

          service.saveCourseDef(courseDefinition);
      }
        return "redirect:/courseDef";
    }


}
