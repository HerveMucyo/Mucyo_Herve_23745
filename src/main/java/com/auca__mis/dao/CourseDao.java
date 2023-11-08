package com.auca__mis.dao;

import com.auca__mis.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CourseDao extends JpaRepository<Course, UUID> {
}
