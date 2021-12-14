package com.university_register.register.repository;

import com.university_register.register.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProgramRepository extends JpaRepository< Program, Long> {

    Optional <Program> findByname (String name);
}
