package com.university_register.register.converter;

import com.university_register.register.dto.TeacherDto;
import com.university_register.register.entity.Student;
import com.university_register.register.entity.StudentProgram;
import com.university_register.register.entity.Teacher;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TeacherConverter {

    public TeacherDto toTeacherDto (Teacher teacher){
        return TeacherDto.builder()
                .id(teacher.getId())
                .fullName(teacher.getFullName())

                .studentProgramIds(teacher.getStudentPrograms()
                        .stream()
                        .map(StudentProgram::getId)
                        .collect(Collectors.toSet()))
                .build();
    }

    public  Teacher toTeacher (TeacherDto teacherDto){
        return Teacher.builder()
                .id(teacherDto.getId())
                .fullName(teacherDto.getFullName())

                .studentPrograms(teacherDto.getStudentProgramIds()
                        .stream()
                        .map((studentProgramId) -> StudentProgram.builder().id(studentProgramId).build())
                        .collect(Collectors.toSet()))
                        .build();
    }
}
