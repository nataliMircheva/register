package com.university_register.register.repository;

import com.university_register.register.entity.Student;
import com.university_register.register.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {




}
