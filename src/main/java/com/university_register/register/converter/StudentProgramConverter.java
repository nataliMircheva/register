package com.university_register.register.converter;

import com.university_register.register.dto.StudentProgramDto;
import com.university_register.register.dto.TeacherDto;
import com.university_register.register.entity.Duration;
import com.university_register.register.entity.StudentProgram;
import com.university_register.register.entity.Teacher;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class StudentProgramConverter {
    public StudentProgramDto toStudentProgramDto (StudentProgram studentProgram){
        return StudentProgramDto.builder()
                .id(studentProgram.getId())
                .name(studentProgram.getName())
                .teacherIds(studentProgram.getTeachers()
                        .stream()
                        .map(Teacher::getId)
                        .collect(Collectors.toSet()))
                .durationId(studentProgram.getId())
                .build();

    }

    public  StudentProgram toStudentProgram (StudentProgramDto studentProgramDto){
        return StudentProgram.builder()
                .id(studentProgramDto.getId())
                .name(studentProgramDto.getName())
                .teachers(studentProgramDto.getTeacherIds()
                        .stream()
                        .map((teacherId) -> Teacher.builder().id(teacherId).build())
                        .collect(Collectors.toSet()))
                .duration(Duration.builder().id(studentProgramDto.getDurationId()).build())
                .teachers(studentProgramDto.getTeacherIds()
                        .stream()
                        .map((teacherId) -> Teacher.builder().id(teacherId).build())
                        .collect(Collectors.toSet()))
                .build();



    }
}
