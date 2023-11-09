package com.auca__mis.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "SEMESTER")
    private Semester semester;
    @ManyToOne
    @JoinColumn(name = "TEACHER")
    private Teacher teacher;
    @OneToOne
    private CourseDefinition courseDefinition;
    @ManyToOne
    @JoinColumn(name = "ACADEMIC_UNIT")
    private AcademicUnit academicUnit;

}
