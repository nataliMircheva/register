package com.university_register.register.service;

import com.university_register.register.entity.StudentProgram;

import java.util.Set;

public interface StudentProgramService {

    StudentProgram save (StudentProgram studentProgram);
    StudentProgram findById (Long id);
    StudentProgram findByName (String name);
    Set<StudentProgram> findAll();
    StudentProgram update (StudentProgram studentProgram, Long id);
    void delete (Long id);
}
