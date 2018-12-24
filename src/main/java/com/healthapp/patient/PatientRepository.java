package com.healthapp.patient;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {

    public Patient findPatientById(long id );
    public List<Patient> findPatientsByFirstName(String firstName);

    Patient findPatientByEmail(String email);
}
