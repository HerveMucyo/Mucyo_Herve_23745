package com.auca__mis.controller;

import com.auca__mis.model.Semester;
import com.auca__mis.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class SemesterController {
    private final SemesterService semesterService;
    @Autowired
    public SemesterController(SemesterService semesterService) {
        this.semesterService = semesterService;
    }

    @GetMapping("/semester")
    public String showSemesterDashboard(Model model) {

        List<Semester> semestersList = semesterService.getAllSemesters();
        model.addAttribute("semester",new Semester());
        model.addAttribute("semestersList", semestersList);
        return "semester";

    }
    @PostMapping("/semester/create")
    public String createSemester(@ModelAttribute("semester") Semester semester) {
        semesterService.saveSemester(semester);
        return "redirect:/semester";
    }

//    @RequestMapping(value = "semester/update", method = RequestMethod.GET)
//    public String updateSemester(@ModelAttribute("semester") Semester semester) {
//        semesterService.updateSemester(semester);
//        return "redirect:/semester";
//    }

    @RequestMapping(value = "semester/delete/{id}", method = RequestMethod.GET)
    public String deleteSemester(@PathVariable UUID id) {
        semesterService.deleteSemester(id);
        return "redirect:/semester";
    }

    @RequestMapping(path = "/semester/update/{id}", method = RequestMethod.GET)
    public String editSemester(Model model, @PathVariable(value = "id")UUID id){
        model.addAttribute("semester", semesterService.getSemesterById(id));
        return "redirect:/semester";
    }

}
