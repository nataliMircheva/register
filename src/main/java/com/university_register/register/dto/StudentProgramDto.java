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
public class StudentProgramDto {

    private Long id;

    private String name;

    private Set<Long> teacherIds;



    private Long durationId;
}
