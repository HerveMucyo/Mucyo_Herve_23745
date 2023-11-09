package com.auca__mis.controller;

import com.auca__mis.model.CourseDefinition;
import com.auca__mis.service.ICourseDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String createCourseDef(@ModelAttribute("courseDef") CourseDefinition courseDefinition) {
        service.saveCourseDef(courseDefinition);
        return "redirect:/courseDef";
    }

//    @RequestMapping(value = "semester/update", method = RequestMethod.GET)
//    public String updateSemester(@ModelAttribute("semester") Semester semester) {
//        semesterService.updateSemester(semester);
//        return "redirect:/semester";
//    }
    @RequestMapping(value = "courseDef/delete/{id}", method = RequestMethod.GET)
    public String deleteCourseDef(@PathVariable UUID id) {
        service.deleteCourseById(id);
        return "redirect:/courseDef";
    }
    @RequestMapping(path = "/courseDef/update/{id}", method = RequestMethod.GET)
    public String editCourseDef(@ModelAttribute("courseDefs")
                                    Model model,
                                 @PathVariable UUID id){
        model.addAttribute("courseDefs", service.getCourseDefById(id));
        return "redirect:/CourseDefinition";
    }


}
