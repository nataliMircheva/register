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
public class DurationDto {

    private Long id;
    private Integer years;
    private Set<Long> studentProgramIds;
}
