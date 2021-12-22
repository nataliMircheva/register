package com.university_register.register.converter;

import com.university_register.register.dto.DurationDto;
import com.university_register.register.entity.Duration;
import com.university_register.register.entity.StudentProgram;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
@Component
public class DurationConverter {

    public DurationDto toDurationDto(Duration duration){
        return DurationDto.builder()
                .id(duration.getId())
                .studentProgramIds(duration.getPrograms()
                        .stream()
                        .map(StudentProgram::getId)
                        .collect(Collectors.toSet()))
                .years(duration.getYears())
                .build();
    }

    public Duration toDuration (DurationDto durationDto){
        return Duration.builder()
                .id(durationDto.getId())
                .programs(durationDto.getStudentProgramIds()
                        .stream()
                        .map((studentProgramId) -> StudentProgram.builder().id(studentProgramId).build())
                        .collect(Collectors.toSet()))
                .build();
    }
}
