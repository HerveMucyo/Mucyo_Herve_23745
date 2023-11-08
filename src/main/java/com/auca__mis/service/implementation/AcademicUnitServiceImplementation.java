package com.auca__mis.service.implementation;

import com.auca__mis.controller.AcademicUnitController;
import com.auca__mis.dao.AcademicUnitDao;
import com.auca__mis.enums.EAcademicUnit;
import com.auca__mis.model.AcademicUnit;
import com.auca__mis.service.AcademicUnitService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;


@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class AcademicUnitServiceImplementation implements AcademicUnitService {


    private AcademicUnitDao academicUnitDao;


    @Override
    public void saveAcademicUnit(AcademicUnit academicUnit) {
        try {
            AcademicUnitController.randomCodes(academicUnit);

            academicUnitDao.save(academicUnit);

        }catch (Exception ex){
            log.error(ex.toString());
        }
    }

    @Override
    public List<AcademicUnit> findAll() {
        return academicUnitDao.findAll();
    }

    @Override
    public AcademicUnit findUnitByName(String name) {
        Optional<AcademicUnit>optional=academicUnitDao.findAcademicUnitsByName(name);

        return optional.orElse(null);
    }

    @Override
    public void deleteUnit(UUID id) {
if(!academicUnitDao.existsById(id)) {
    throw new RuntimeException("Unit not found");
}
    academicUnitDao.deleteById(id);
    }

    @Override
    public Optional<AcademicUnit> findUnitById(UUID id) {
        Optional<AcademicUnit>optional=academicUnitDao.findById(id);
        if(!academicUnitDao.existsById(id)) {
            throw new RuntimeException("Unit not found");
        }
        return optional;
    }
}
