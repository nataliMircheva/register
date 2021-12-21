package com.university_register.register.service.impl;

import com.university_register.register.entity.Student;
import com.university_register.register.entity.StudentProgram;
import com.university_register.register.exception.DuplicateRecordException;
import com.university_register.register.exception.ResourceNotFoundException;
import com.university_register.register.repository.StudentProgramRepository;
import com.university_register.register.service.StudentProgramService;
import com.university_register.register.service.StudentService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class StudentProgramServiceImpl implements StudentProgramService {

    private final StudentProgramRepository studentProgramRepository;





    public StudentProgramServiceImpl(StudentProgramRepository studentProgramRepository) {
        this.studentProgramRepository = studentProgramRepository;

    }


    @Override
    public StudentProgram save(StudentProgram studentProgram) {
        try {

            return studentProgramRepository.save(StudentProgram.builder()
                    .id(studentProgram.getId())
                    .name(studentProgram.getName())
                    .students(studentProgram.getStudents())
                    .teacher(studentProgram.getTeacher())
                    .duration(studentProgram.getDuration())
                    .build());

        }catch (DataIntegrityViolationException exception){
            throw new DuplicateRecordException(String.format("StudentProgram with this name %d already exists",studentProgram));
        }
    }

    @Override
    public StudentProgram findById(Long id) {
        return studentProgramRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Student program with id: %d does not exists",id)));
    }

    @Override
    public StudentProgram findByName(String name) {
        return studentProgramRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Student program with name: %d does not exists",name)));
    }

    @Override
    public Set<StudentProgram> findAll() {
        return new HashSet<>(studentProgramRepository.findAll());
    }

    @Override
    public StudentProgram update(StudentProgram studentProgram, Long id) {
        StudentProgram foundStudentProgram = findById(id);
        StudentProgram updateStudentProgram = StudentProgram.builder()
                .id(foundStudentProgram.getId())
                .name(studentProgram.getName())
                .students(studentProgram.getStudents())
                .duration(studentProgram.getDuration())
                .build();
            return studentProgramRepository.save(updateStudentProgram);

    }

    @Override
    public void delete(Long id) {
        studentProgramRepository.deleteById(id);

    }
}
