package com.healthapp.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Patient findDoctorByEmail(String email) {
        return patientRepository.findPatientByEmail(email);
    }

    public Patient findPatientById(long id) {
        return patientRepository.findPatientById(id);
    }

    public List<Patient> findPatientsByFirstName(String firstName) {
        return patientRepository.findPatientsByFirstName(firstName);
    }

    public Patient addPatient(Patient doc) {
        return patientRepository.save(doc);
    }

    @SuppressWarnings("Duplicates")
    public void updatePatient(Patient patient, long id) {

        Patient patientToUpdate = findPatientById(id);
        patientToUpdate.setFirstName(patient.getFirstName());
        patientToUpdate.setLastName(patient.getLastName());
        patientToUpdate.setBirthDate(patient.getBirthDate());
        patientToUpdate.setPhoto(patient.getPhoto());
        patientToUpdate.setPhone(patient.getPhone());
        patientToUpdate.getUser().setPassword((patient.getUser().getPassword()));
        patientRepository.save(patientToUpdate);


    }


    public void deletePatient(long id) {
        patientRepository.delete(patientRepository.findPatientById(id));
    }

}
