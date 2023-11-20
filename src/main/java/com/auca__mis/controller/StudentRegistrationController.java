package com.auca__mis.controller;

import com.auca__mis.enums.ERegistrationStatus;
import com.auca__mis.model.StudentRegistration;
import com.auca__mis.service.IAcademicUnitService;
import com.auca__mis.service.ISemesterService;
import com.auca__mis.service.IStudRegService;
import com.auca__mis.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class StudentRegistrationController {
    IStudRegService registrationService;

    IStudentService studentService;

    IAcademicUnitService unitService;

    ISemesterService semesterService;

    @Autowired
    public StudentRegistrationController(IStudRegService registrationService, IStudentService studentService, IAcademicUnitService unitService, ISemesterService semesterService) {
        this.registrationService = registrationService;
        this.studentService = studentService;
        this.unitService = unitService;
        this.semesterService = semesterService;
    }

    @PostMapping("/saveRegistration")
    public String saveRegistration(@ModelAttribute StudentRegistration registration, @RequestParam String action) {
        registration.setStatus(ERegistrationStatus.ADMITTED);
        if (action.equals("Update")) {
            UUID id = registration.getId();
            registration.setId(id);
            registrationService.createStudentRegistration(registration);
        } else if (action.equals("Submit")) {
            registration.setId(UUID.randomUUID());
            registrationService.createStudentRegistration(registration);
        } else {
            UUID id = registration.getId();
            registration.setId(id);
            registrationService.deleteStudentRegistration(registration);
        }

        return "redirect:/studentRegistration";
    }

    @GetMapping("/studentRegistration")
    public String findAllRegistrations(Model model) {
        model.addAttribute("registrationList", registrationService.registrationList());
        model.addAttribute("regForm", new StudentRegistration());
        model.addAttribute("studentList", studentService.getAllStudents());
        model.addAttribute("unitList", unitService.findAll());
        model.addAttribute("semList", semesterService.getAllSemesters());
        return "studentRegistration";
    }
}
