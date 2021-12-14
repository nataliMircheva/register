package com.university_register.register.repository;

import com.university_register.register.entity.Duration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DurationRepository extends JpaRepository<Duration,Long> {

    Optional<Duration> findByYears (Integer years);
}
