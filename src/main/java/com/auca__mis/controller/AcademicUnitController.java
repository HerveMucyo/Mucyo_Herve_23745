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
    private final IAcademicUnitService iAcademicUnitService;
    private final Random random = new Random();

    @Autowired
    public AcademicUnitController(IAcademicUnitService iAcademicUnitService) {
        this.iAcademicUnitService = iAcademicUnitService;
    }

    @GetMapping("/academicUnit")
    public String showAcademicUnitDashboard(Model model) {
        List<AcademicUnit> academicUnitList = iAcademicUnitService.findAll();
        model.addAttribute("academicUnitList", academicUnitList);
        model.addAttribute("acadUnit", new AcademicUnit());
        model.addAttribute("facultyForm", new AcademicUnit());
        model.addAttribute("department", new AcademicUnit());
        return "academicUnit";
    }

    @PostMapping("/acadUnit/createProgram")
    public String createProgram(@ModelAttribute("acadUnit") AcademicUnit academicUnit) {
        int randomCode = generateRandomCode();
        academicUnit.setId(UUID.randomUUID());
        academicUnit.setCode(String.valueOf(randomCode));
        academicUnit.setName(academicUnit.getName());
        academicUnit.setUnit(EAcademicUnit.PROGRAMME);
        iAcademicUnitService.saveAcademicUnit(academicUnit);
        return "redirect:/academicUnit";
    }

    @PostMapping("/acadUnit/createFaculty")
    public String createFaculty(@ModelAttribute("facultyForm") AcademicUnit unit) {
        AcademicUnit parent = iAcademicUnitService.findUnitByName(unit.getAcademicUnit().getName());
        int randomCode = generateRandomCode();
        unit.setId(UUID.randomUUID());
        unit.setCode(String.valueOf(randomCode));
        unit.setUnit(EAcademicUnit.FACULTY);
        unit.setAcademicUnit(parent);
        iAcademicUnitService.saveAcademicUnit(unit);
        return "redirect:/academicUnit";
    }

    @PostMapping("/acadUnit/createDepartment")
    public String saveDepUnit(@ModelAttribute("department") AcademicUnit unit){
        AcademicUnit parent = iAcademicUnitService.findUnitByName(unit.getAcademicUnit().getName());
        int randomCode = generateRandomCode();
        unit.setId(UUID.randomUUID());
        unit.setCode(String.valueOf(randomCode));
        unit.setUnit(EAcademicUnit.DEPARTMENT);
        unit.setAcademicUnit(parent);
        iAcademicUnitService.saveAcademicUnit(unit);
        return "redirect:/academicUnit";
    }

    private int generateRandomCode() {
        int min = 10000; // Smallest 5-digit number
        int max = 99999; // Largest 5-digit number
        return random.nextInt(max - min + 1) + min;
    }
}
