package org.healthcare;

import org.healthcare.entity.Appointment;
import org.healthcare.repository.HealthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@RestController
public class HealthController {
    @Autowired
    HealthRepository healthRepository;
    @GetMapping("/api/appointments")
    public List<Appointment> getAppointment(){
        return healthRepository.findAll();
    }
    @PostMapping("/api/appointments")
    public Appointment appointmentSave(@RequestBody Map<String, String> body) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf1.parse(body.get("date"));
        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
        return healthRepository.save(new Appointment(Integer.parseInt(body.get("patientId")), sqlStartDate));
    }

    @PutMapping("/api/appointments/{appointmentId}")
    public Appointment updateAppointment(@RequestBody Map<String, String> body, @PathVariable int appointmentId) throws ParseException {
        Appointment appointment = healthRepository.findById(appointmentId).get();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf1.parse(body.get("date"));
        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
        appointment.setDate(sqlStartDate);
        return healthRepository.save(appointment);
    }

    @DeleteMapping("/api/appointments/{appointmentId}")
    public boolean deleteAppointment(@PathVariable int appointmentId) throws ParseException {
        healthRepository.deleteById(appointmentId);
        return true;
    }

}
