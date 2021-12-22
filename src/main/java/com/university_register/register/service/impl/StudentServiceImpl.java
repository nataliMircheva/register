package com.university_register.register.service.impl;

import com.university_register.register.entity.Student;
import com.university_register.register.entity.StudentProgram;
import com.university_register.register.entity.Teacher;
import com.university_register.register.exception.DuplicateRecordException;
import com.university_register.register.exception.ResourceNotFoundException;
import com.university_register.register.repository.StudentRepository;
import com.university_register.register.service.StudentProgramService;
import com.university_register.register.service.StudentService;
import com.university_register.register.service.TeacherService;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public  class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;


    private final StudentProgramService studentProgramService ;


    public StudentServiceImpl(StudentRepository studentRepository, StudentProgramService studentProgramService) {
        this.studentRepository = studentRepository;



        this.studentProgramService = studentProgramService;
    }


    @Override
    public Student save(Student student) {
        try {




            StudentProgram studentProgram = studentProgramService.findById(student.getStudentProgram().getId());

            return studentRepository.save(Student.builder()
                    .id(student.getId())
                    .fullName(student.getFullName())
                    .studentProgram(studentProgram)
                    .build());


            }catch (DataIntegrityViolationException exception){
            throw new DuplicateRecordException(String.format("Student with this name %d already exists",student));
        }

    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Student with id: %d does not exists",id)));
    }




    @Override
    public Set<Student> findAll() {
        return new HashSet<>(studentRepository.findAll());
    }

    @Override
    public Student update(Student student, Long id) {
        Student foundStudent = findById(id);
        Student updateStudent = Student.builder()
                .id(foundStudent.getId())
                .fullName(student.getFullName())
                .ucn(student.getUcn())
                .studentProgram(student.getStudentProgram())
                .build();
        return save(updateStudent) ;
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);

    }
}
