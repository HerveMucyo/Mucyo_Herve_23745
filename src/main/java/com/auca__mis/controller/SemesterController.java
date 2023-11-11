package com.auca__mis.controller;

import com.auca__mis.model.Semester;
import com.auca__mis.service.ISemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class SemesterController {
    private final ISemesterService ISemesterService;

    @Autowired
    public SemesterController(ISemesterService ISemesterService) {
        this.ISemesterService = ISemesterService;
    }

    @GetMapping("/semester")
    public String showSemesterDashboard(Model model) {

        List<Semester> semestersList = ISemesterService.getAllSemesters();
        model.addAttribute("semester", new Semester());
        model.addAttribute("semestersList", semestersList);
        return "semester";

    }

    @PostMapping("/semester/create")
    public String createSemester(@ModelAttribute("semester") Semester semester, @Param("action") String action) {


        if (action.equals("Delete")) {
            ISemesterService.deleteSemester(semester);
        } else if (action.equals("Update")) {
            semester.setId(semester.getId());
            ISemesterService.updateSemester(semester);
        } else {
            ISemesterService.saveSemester(semester);
        }
        return "redirect:/semester";
    }


}
