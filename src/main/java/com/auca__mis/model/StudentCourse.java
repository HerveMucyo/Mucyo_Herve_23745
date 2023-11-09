package com.auca__mis.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourse {
    @Id
    private UUID id;
    private Integer credits;
    private BigDecimal results;
    @ManyToOne
    @JoinColumn(name = "STUDENT_REGISTRATION")
    private StudentRegistration studentRegistration;
    @OneToOne
    private Course course;

}
