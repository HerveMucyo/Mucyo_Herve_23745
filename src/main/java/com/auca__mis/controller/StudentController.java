package com.auca__mis.controller;


import com.auca__mis.model.Student;
import com.auca__mis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class StudentController {
private final StudentService studentService;
@Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    private String showStudentDashboard(Model model){

    List<Student>studentList=studentService.getAllStudents();
    model.addAttribute("student",new Student());
    model.addAttribute("studentsList",studentList);

    return "student";

    }

    @PostMapping("/student/create")
    public String createStudent(@ModelAttribute("student") Student student){
    studentService.saveStudent(student);
    return "redirect:/student";
    }

    @RequestMapping(value = "student/update", method = RequestMethod.POST)
    public String updateStudent(@ModelAttribute("student") Student student) {
        studentService.updateStudent(student);
        return "redirect:/student";
    }

    @RequestMapping(value = "student/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable UUID id) {
        studentService.deleteStudent(id);
        return "redirect:/student";
    }


}

