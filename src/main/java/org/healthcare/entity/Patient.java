package org.healthcare.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patient {

    @Id
    private int patientid;
    private String patientname;

    public Patient(){}

    public Patient(int patientid, String patientname) {
        this.patientid = patientid;
        this.patientname = patientname;
    }

    public int getPatientid() {
        return patientid;
    }

    public void setPatientid(int patientid) {
        this.patientid = patientid;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }
}
