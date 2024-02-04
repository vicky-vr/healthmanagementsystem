package org.healthcare;

import org.healthcare.entity.Appointment;
import org.healthcare.entity.Patient;
import org.healthcare.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    PatientRepository patientRepository;
    @GetMapping("/api/patients/{patientId}")
    public Patient getAppointment(@PathVariable Integer patientId){
        return patientRepository.findById(patientId).get();
    }
}
