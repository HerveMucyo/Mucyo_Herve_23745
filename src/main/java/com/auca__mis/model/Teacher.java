package com.auca__mis.model;

import com.auca__mis.enums.EQualification;
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
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String code;
    private String name;
    @Enumerated(EnumType.STRING)
    private EQualification qualification;
    @OneToMany(mappedBy = "teacher")
    private List<Course> courseList;
}
