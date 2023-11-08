package com.auca__mis.dao;

import com.auca__mis.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface StudentDao extends JpaRepository<Student, UUID> {
}
