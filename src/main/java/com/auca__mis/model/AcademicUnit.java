package com.auca__mis.model;

import com.auca__mis.enums.EAcademicUnit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AcademicUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true)
    private String code;
    private String name;
    @Enumerated(EnumType.STRING)
    private EAcademicUnit unit;
    @ManyToOne
    @JoinColumn(name = "ACADEMIC_UNIT")
    private AcademicUnit academicUnit;

}
