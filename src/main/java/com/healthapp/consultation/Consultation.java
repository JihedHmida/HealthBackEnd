package com.healthapp.consultation;


import com.healthapp.doctor.Doctor;
import com.healthapp.patient.Patient;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Consultation implements Serializable {

    private static final  long serialVersionUID = 1L ;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long    id;
    private Date    date;
    private String  note;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "DOCTOR_ID")
    private Doctor  doctor;

    public Consultation(Date date, String note, Patient patient, Doctor doctor) {
        this.date = date;
        this.note = note;
        this.patient = patient;
        this.doctor = doctor;
    }

    public Consultation() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
