package com.auca__mis.model;

import com.auca__mis.enums.ERegistrationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRegistration {
    @Id
    private UUID id;
    private LocalDate registrationDate;
    @ManyToOne
    @JoinColumn(name = "STUDENT")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "UNIT")
    private AcademicUnit academicUnit;
    @ManyToOne
    @JoinColumn(name = "SEMESTER")
    private Semester semester;
    @Enumerated(EnumType.STRING)
    private ERegistrationStatus status;
    @OneToMany
    private List<StudentCourse> studentCoursesList;
//hi
}
