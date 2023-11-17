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

    @Autowired
    public AcademicUnitController(IAcademicUnitService iAcademicUnitService) {
        this.iAcademicUnitService = iAcademicUnitService;
    }

    @GetMapping("/acadUnit")
    public String showAcademicUnitDashboard(Model model) {
        List<AcademicUnit> academicUnitList = iAcademicUnitService.findAll();
        model.addAttribute("academicUnitList", academicUnitList);
        model.addAttribute("acadUnit", new AcademicUnit());
        model.addAttribute("faculty", new AcademicUnit());
        model.addAttribute("department", new AcademicUnit());
        return "academicUnit";
    }


    @PostMapping("/acadUnit/createProgram")
    public String createProgram(@ModelAttribute("acadUnit") AcademicUnit academicUnit) {

        academicUnit.setCode(String.valueOf(randomCode));
        academicUnit.setName(academicUnit.getName());
        academicUnit.setUnit(EAcademicUnit.PROGRAMME);

        iAcademicUnitService.saveAcademicUnit(academicUnit);
        return "redirect:/acadUnit";
    }

    @PostMapping("/acadUnit/createFaculty")
    public String createFaculty(@ModelAttribute AcademicUnit unit) {

        AcademicUnit parent = iAcademicUnitService.findUnitByName(unit.getAcademicUnit().getName());
        int randomCode = random.nextInt(max - min + 1) + min;

        unit.setId(UUID.randomUUID());
        unit.setCode(String.valueOf(randomCode));
        unit.setUnit(EAcademicUnit.FACULTY);
        unit.setAcademicUnit(parent);

        iAcademicUnitService.saveAcademicUnit(unit);
        return "redirect:/acadUnit";
    }

    @RequestMapping(value = "/acadUnit/delete/{id}", method = RequestMethod.GET)
    public String deleteAcademicUnit(@PathVariable AcademicUnit academicUnit) {
        iAcademicUnitService.deleteUnit(academicUnit);
        return "redirect:/acadUnit";
    }

    @RequestMapping(path = "/acadUnit/update/{id}", method = RequestMethod.GET)
    public String editAcademicUnit(@ModelAttribute("acadUnit") Model model, @PathVariable(value = "id") AcademicUnit academicUnitd) {
        model.addAttribute("acadUnit", iAcademicUnitService.findUnitById(academicUnitd));

        return "redirect:/acadUnit";
    }

    int min = 10000; // Smallest 5-digit number
    int max = 99999; // Largest 5-digit number
    Random random = new Random();
    int randomCode = random.nextInt(max - min + 1) + min;
}
