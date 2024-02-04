package org.healthcare.repository;

import org.healthcare.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
