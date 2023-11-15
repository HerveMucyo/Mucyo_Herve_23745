package com.auca__mis.controller;

import com.auca__mis.enums.EAcademicUnit;
import com.auca__mis.model.AcademicUnit;

import com.auca__mis.service.IAcademicUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Controller
public class AcademicUnitController {
    private final IAcademicUnitService IAcademicUnitService;
@Autowired
    public AcademicUnitController(IAcademicUnitService IAcademicUnitService) {
        this.IAcademicUnitService = IAcademicUnitService;
    }

    @GetMapping("/acadUnit")
    public String showAcademicUnitDashboard(Model model) {
        List<AcademicUnit> academicUnitList = IAcademicUnitService.findAll();
        model.addAttribute("acadUnit",new AcademicUnit());
        model.addAttribute("academicUnitList", academicUnitList);
        return "academicUnit";
    }
    @PostMapping("/acadUnit/create")
    public String createAcademicUnit(@ModelAttribute("acadUnit") AcademicUnit academicUnit) {


        IAcademicUnitService.saveAcademicUnit(academicUnit);
        return "redirect:/acadUnit";
    }



    @RequestMapping(value = "/acadUnit/delete/{id}", method = RequestMethod.GET)
    public String deleteAcademicUnit(@PathVariable AcademicUnit academicUnit) {
        IAcademicUnitService.deleteUnit(academicUnit);
        return "redirect:/acadUnit";
    }
    @RequestMapping(path = "/acadUnit/update/{id}", method = RequestMethod.GET)
    public String editAcademicUnit(@ModelAttribute("acadUnit") Model model, @PathVariable(value = "id")AcademicUnit academicUnitd){
        model.addAttribute("acadUnit", IAcademicUnitService.findUnitById(academicUnitd));
        return "redirect:/acadUnit";
    }
}
