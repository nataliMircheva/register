package com.university_register.register.dto;

import com.university_register.register.entity.StudentProgram;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class StudentDto {

    private Long id;

    private String fullName;

    private Long studentProgramId;

    private Set<Long> teacherIds;

}
