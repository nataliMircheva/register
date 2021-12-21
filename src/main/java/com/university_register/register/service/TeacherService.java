package com.university_register.register.service;

import com.university_register.register.entity.Teacher;

import java.util.Set;

public interface TeacherService {

    Teacher save (Teacher teacher);

    Teacher findById (Long id);
    Set<Teacher> findAll ();
    Teacher update (Teacher teacher, Long id);
    void delete (Long id);

}
