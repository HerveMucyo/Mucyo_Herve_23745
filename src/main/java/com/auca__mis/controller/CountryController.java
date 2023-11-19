package com.auca__mis.controller;

import com.auca__mis.model.Country;
import com.auca__mis.model.Semester;
import com.auca__mis.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CountryController {
    private final ICountryService iCountryService;

    @Autowired
    public CountryController(ICountryService iCountryService) {
        this.iCountryService = iCountryService;
    }

    @GetMapping("/country")
    public String showCountry(Model model) {
        List<Country> countryList = iCountryService.findAll();
        model.addAttribute("country", new Country());
        model.addAttribute("countryList", countryList);
        return "country";

    }

    @PostMapping("/country/create")
    public String createCountry(@ModelAttribute("country") Country country, @Param("action") String action) {
        iCountryService.saveCountry(country);
        return "redirect:/country";
    }

}
