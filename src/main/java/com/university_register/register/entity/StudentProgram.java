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
@Table(name = "student_programs")
public class StudentProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false,unique = true)
    private String name;

  @OneToMany(mappedBy = "studentProgram")
   private Set<Student> students;

    @ManyToOne
    @JoinColumn(name = "teacher_id", foreignKey = @ForeignKey (name = "fk_teacher_id"))
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "duration_id", foreignKey = @ForeignKey (name = "fk_duration_id"))
    private Duration duration;
}
