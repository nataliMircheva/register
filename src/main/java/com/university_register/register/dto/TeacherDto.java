package com.university_register.register.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class TeacherDto {

    private Long id;
    private String fullName;
    private Set<Long> studentIds;
    private Set<Long> studentProgramIds;
}
