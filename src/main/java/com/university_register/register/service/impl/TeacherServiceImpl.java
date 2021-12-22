package com.university_register.register.service.impl;

import com.university_register.register.entity.StudentProgram;
import com.university_register.register.entity.Student;
import com.university_register.register.entity.Teacher;
import com.university_register.register.exception.DuplicateRecordException;
import com.university_register.register.exception.ResourceNotFoundException;
import com.university_register.register.repository.TeacherRepository;
import com.university_register.register.service.StudentProgramService;
import com.university_register.register.service.StudentService;
import com.university_register.register.service.TeacherService;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service

public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final StudentProgramService studentProgramService;


    public TeacherServiceImpl(TeacherRepository teacherRepository, StudentProgramService studentProgramService) {
        this.teacherRepository = teacherRepository;
        this.studentProgramService = studentProgramService;

    }


    @Override
    public Teacher save(Teacher teacher) {

        try { Set<StudentProgram> programs = new HashSet<>();
            for(StudentProgram studentProgram : teacher.getStudentPrograms()) {

                StudentProgram foundProgram = studentProgramService.findById(studentProgram.getId());
                programs.add(foundProgram);

            }

            return teacherRepository.save(Teacher.builder()
                    .id(teacher.getId())
                    .fullName(teacher.getFullName())
                          .ucn(teacher.getUcn())
                            .studentPrograms(programs)
                            .build());

        }catch (DataIntegrityViolationException exception){
            throw new DuplicateRecordException(String.format("Teacher with this name %d already exists",teacher));
        }

    }



    @Override
    public Teacher findById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Teacher with id: %d does not exists",id)));
    }

    @Override
    public Set<Teacher> findAll() {
            return new HashSet<>(teacherRepository.findAll());


    }

    @Override
    public Teacher update(Teacher teacher, Long id) {

        Teacher foundTeacher = findById(id);
        Teacher updateTeacher = Teacher.builder()
                .id(foundTeacher.getId())
                .fullName(teacher.getFullName())
                .studentPrograms(teacher.getStudentPrograms())

               .ucn(teacher.getUcn())
                .build();
        return teacherRepository.save(updateTeacher);
    }

    @Override
    public void delete(Long id) {
        teacherRepository.deleteById(id);
    }
}
