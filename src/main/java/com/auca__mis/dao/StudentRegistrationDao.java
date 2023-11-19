package com.auca__mis.dao;

import com.auca__mis.model.StudentRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRegistrationDao extends JpaRepository<StudentRegistration, UUID> {
    List<StudentRegistration> findStudentRegistrationBySemesterId(UUID semester_id);
    List<StudentRegistration> findStudentRegistrationBySemesterIdAndUnitId(UUID semId, UUID unitId);

}
