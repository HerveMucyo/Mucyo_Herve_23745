package com.auca__mis.service;

import com.auca__mis.model.AcademicUnit;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IAcademicUnitService {
    AcademicUnit  saveAcademicUnit(AcademicUnit academicUnit);
    public List<AcademicUnit> findAll();

    public AcademicUnit findUnitByName(String name);

    public void deleteUnit(AcademicUnit academicUnit);

   public AcademicUnit findUnitById(AcademicUnit academicUnit);


}
