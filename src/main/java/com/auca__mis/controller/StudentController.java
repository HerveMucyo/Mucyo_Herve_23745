package com.auca__mis.controller;


import com.auca__mis.model.Student;
import com.auca__mis.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class StudentController {
private final IStudentService IStudentService;
@Autowired
    public StudentController(IStudentService IStudentService) {
        this.IStudentService = IStudentService;
    }

    @GetMapping("/student")
    private String showStudentDashboard(Model model){

    List<Student>studentList= IStudentService.getAllStudents();
    model.addAttribute("student",new Student());
    model.addAttribute("studentsList",studentList);

    return "student";

    }

    @PostMapping("/student/create")
    public String createStudent(@ModelAttribute("student") Student student){
    IStudentService.saveStudent(student);
    return "redirect:/student";
    }

    @RequestMapping(value = "student/update", method = RequestMethod.POST)
    public String updateStudent(@ModelAttribute("student") Student student) {
        IStudentService.updateStudent(student);
        return "redirect:/student";
    }

    @RequestMapping(value = "student/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable Student student) {
        IStudentService.deleteStudent(student);
        return "redirect:/student";
    }


}

