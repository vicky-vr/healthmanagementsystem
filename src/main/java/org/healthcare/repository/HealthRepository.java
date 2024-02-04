package org.healthcare.repository;

import org.healthcare.entity.Appointment;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthRepository extends JpaRepository<Appointment, Integer> {

}
