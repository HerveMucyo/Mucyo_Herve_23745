package com.auca__mis.controller;


import com.auca__mis.model.Teacher;
import com.auca__mis.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class TeacherController {
    private final TeacherService teacherService;

@Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teacher")
    public String showTeacherDashboard(Model model){
        List<Teacher>teacherList=teacherService.getAllTeachers();
        model.addAttribute("teacherList",teacherList);
        model.addAttribute("teacher",new Teacher());
    return "teacher";
    }

    @PostMapping("/teacher/create")
    public String createTeacher(@ModelAttribute("teacher")Teacher teacher){
    teacherService.saveTeacher(teacher);
    return "redirect:/teacher";
    }
    @RequestMapping(value = "teacher/update", method = RequestMethod.POST)
    public String updateTeacher(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.saveTeacher(teacher);
        return "redirect:/teacher";
    }

    @RequestMapping(value = "teacher/delete/{id}", method = RequestMethod.DELETE)
    public String deleteTeacher(@PathVariable UUID id) {
       teacherService.deleteTeacherById(id);
        return "redirect:/teacher";
    }

}
