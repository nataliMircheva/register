package com.university_register.register.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false,length = 255)
    private String fullName;

    @NotNull
    @Column(nullable = false,unique = true,length = 10)
    private String ucn;

    @ManyToMany
    @JoinTable(name = "teachers_students"
            ,joinColumns = @JoinColumn(name = "teacher_id")
            ,inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Student> students;


    @OneToMany(mappedBy = "teacher")
    private Set<StudentProgram> studentPrograms;

}
