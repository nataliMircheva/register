package com.university_register.register.service.impl;

import com.university_register.register.entity.Duration;
import com.university_register.register.exception.DuplicateRecordException;
import com.university_register.register.exception.ResourceNotFoundException;
import com.university_register.register.repository.DurationRepository;
import com.university_register.register.service.DurationService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class DurationServiceImpl implements DurationService {
    private final DurationRepository durationRepository;

    public DurationServiceImpl(DurationRepository durationRepository) {
        this.durationRepository = durationRepository;
    }

    @Override
    public Duration save(Duration duration) {
       try {
           return durationRepository.save(Duration.builder()
                   .id(duration.getId())
                   .programs(duration.getPrograms())
                   .years(duration.getYears())
                   .build());
       }catch (DataIntegrityViolationException exception){
           throw new DuplicateRecordException(String.format("Duration with this name %d already exists",duration));
       }
    }

    @Override
    public Duration findById(Long id) {
        return durationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Duration with id: %d does not exists",id)));
    }
}
