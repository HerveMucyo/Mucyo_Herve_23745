package com.auca__mis.dao;

import com.auca__mis.model.AcademicUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface AcademicUnitDao extends JpaRepository<AcademicUnit, UUID> {
    @Query("SELECT acc FROM AcademicUnit acc WHERE acc.name=?1")
    Optional<AcademicUnit> findAcademicUnitsByName(String email);


}
