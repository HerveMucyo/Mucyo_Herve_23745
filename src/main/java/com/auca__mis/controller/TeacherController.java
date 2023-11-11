package com.auca__mis.controller;


import com.auca__mis.model.Teacher;
import com.auca__mis.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TeacherController {
    private final ITeacherService ITeacherService;

    @Autowired
    public TeacherController(ITeacherService ITeacherService) {
        this.ITeacherService = ITeacherService;
    }

    @GetMapping("/teacher")
    public String showTeacherDashboard(Model model) {
        List<Teacher> teacherList = ITeacherService.getAllTeachers();
        model.addAttribute("teacherList", teacherList);
        model.addAttribute("teacher", new Teacher());
        return "teacher";
    }

    @PostMapping("/teacher/create")
    public String createTeacher(@ModelAttribute("teacher") Teacher teacher, @Param("action") String action) {
        if (action.equals("Delete")) {
            ITeacherService.deleteTeacherById(teacher);
        } else if (action.equals("Update")) {
            teacher.setId(teacher.getId());
            ITeacherService.updateTeacher(teacher);
        } else {
            ITeacherService.saveTeacher(teacher);
        }
        return "redirect:/teacher";
    }


}
