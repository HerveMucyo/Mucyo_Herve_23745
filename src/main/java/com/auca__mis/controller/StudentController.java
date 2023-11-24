package com.auca__mis.controller;


import com.auca__mis.model.Student;
import com.auca__mis.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RestController
@RequestMapping(value = "/student/",
        consumes ={MediaType.APPLICATION_JSON_VALUE},
        produces ={MediaType.APPLICATION_JSON_VALUE}
)

public class StudentController {
    private final IStudentService IStudentService;

    @Autowired
    public StudentController(IStudentService IStudentService) {
        this.IStudentService = IStudentService;
    }

    @GetMapping("/student")
    private String showStudentDashboard(Model model) {
        List<Student> studentList = IStudentService.getAllStudents();
        model.addAttribute("student", new Student());
        model.addAttribute("studentsList", studentList);
        return "student";
    }

    @PostMapping("/student/create")
    public ResponseEntity<?> createStudent(@ModelAttribute("student") Student student, @Param("action") String action) {

//        if (action.equals("Delete")) {
//            IStudentService.deleteStudent(student);
//        } else if (action.equals("Update")) {
//            student.setId(student.getId());
//            IStudentService.updateStudent(student);
//        } else {
//            IStudentService.saveStudent(student);
//        }
//        return "redirect:/student";
        if (student  !=null){
            Student Student =IStudentService.saveStudent(student);
            if (Student !=null){
                return new ResponseEntity<>("Student saved successfully", HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>("Something is wrong!",HttpStatus.BAD_REQUEST);
            }
        }
        else {
            return new ResponseEntity<>("You are not allowed to send empty data", HttpStatus.BAD_REQUEST);
        }
    }


}

