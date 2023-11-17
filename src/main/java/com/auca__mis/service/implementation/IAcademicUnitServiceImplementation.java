package com.auca__mis.service.implementation;

import com.auca__mis.controller.AcademicUnitController;
import com.auca__mis.dao.IAcademicUnitDao;
import com.auca__mis.enums.EAcademicUnit;
import com.auca__mis.model.AcademicUnit;
import com.auca__mis.service.IAcademicUnitService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Random;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class IAcademicUnitServiceImplementation implements IAcademicUnitService {

    private IAcademicUnitDao academicUnitDao;


    @Override
    public AcademicUnit saveAcademicUnit(AcademicUnit academicUnit) {
        return academicUnitDao.save(academicUnit);
    }

    @Override
    public List<AcademicUnit> findAll() {
        return academicUnitDao.findAll();
    }
    @Override
    public AcademicUnit findUnitByName(String name) {
        return this.academicUnitDao.
                findAcademicUnitsByName(name);
    }

    @Override
    public void deleteUnit(AcademicUnit academicUnit) {
        if (!academicUnitDao.existsById(academicUnit.getId())) {
            throw new RuntimeException("Unit not found");
        }
        academicUnitDao.deleteById(academicUnit.getId());
    }

    @Override
    public AcademicUnit findUnitById(AcademicUnit academicUnit) {
        return this.academicUnitDao.findById(academicUnit.getId())
                .orElseThrow(() -> new RuntimeException("Unit not found with code: " + academicUnit.getCode()));
    }

}
