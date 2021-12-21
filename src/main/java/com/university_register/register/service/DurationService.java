package com.university_register.register.service;

import com.university_register.register.entity.Duration;

public interface DurationService {
    Duration save (Duration duration);
    Duration findById (Long id);
}
