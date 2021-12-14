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
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false,length = 255)
    private String fullName;

    @NotNull
    @Column(nullable = false,unique = true,length = 10)
    private String ucn;

    @ManyToMany(mappedBy = "students")
    private Set<Teacher> teachers;
}
