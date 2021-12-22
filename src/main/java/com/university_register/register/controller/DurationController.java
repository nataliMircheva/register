package com.university_register.register.controller;

import com.university_register.register.converter.DurationConverter;
import com.university_register.register.dto.DurationDto;
import com.university_register.register.entity.Duration;
import com.university_register.register.service.DurationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/durations")
public class DurationController {

    private final DurationService durationService;
    private final DurationConverter durationConverter;

    public DurationController(DurationService durationService, DurationConverter durationConverter) {
        this.durationService = durationService;

        this.durationConverter = durationConverter;
    }

    @PostMapping

    public ResponseEntity<DurationDto> save (@RequestBody DurationDto durationDto){
        Duration duration = durationConverter.toDuration(durationDto);
        Duration savedDuration = durationService.save(duration);

        DurationDto responseDuration = durationConverter.toDurationDto(savedDuration);


        return ResponseEntity.ok(responseDuration);
    }
}
