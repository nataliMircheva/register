package com.university_register.register.repository;

import com.university_register.register.entity.StudentProgram;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentProgramRepository extends JpaRepository<StudentProgram, Long> {

    Optional <StudentProgram> findByName (String name);
}
