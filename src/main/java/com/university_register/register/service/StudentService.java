package com.university_register.register.service;

import com.university_register.register.entity.Student;

import java.util.Set;

public interface StudentService {

    Student save (Student student);
    Student findById (Long id);

    Set<Student> findAll();
    Student update (Student student, Long id);
    void delete (Long id);
}
