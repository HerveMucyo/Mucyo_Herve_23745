package com.auca__mis.dao;

import com.auca__mis.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TeacherDao extends JpaRepository<Teacher, UUID> {
}
