package com.university_register.register.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "durations")
public class Duration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false,unique = true)
    @Range(min = 1,max = 4,message = "Duration can be between 1 and 4 years")
    private Integer years;

    @OneToMany(mappedBy = "duration")
    private Set<StudentProgram> programs;
}
