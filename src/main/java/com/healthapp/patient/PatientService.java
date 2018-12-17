package com.healthapp.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private   PatientRepository patientRepository;

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Patient findPatientById(long id) {
        return patientRepository.findPatientById(id);
    }

    public List<Patient> findPatientsByFirstName(String firstName )
    {
        return patientRepository.findPatientsByFirstName(firstName);
    }

    public void addPatient(Patient doc) {
        patientRepository.save(doc);
    }

    public void updatePatient(Patient doc, long id) {

        Patient patientToUpdate = findPatientById(id);
        patientToUpdate.setFirstName(doc.getFirstName());
        patientToUpdate.setLastName(doc.getLastName());
        patientToUpdate.setEmail(doc.getEmail());
        patientRepository.save(patientToUpdate);
    }


    public void deletePatient(long id) {
        patientRepository.delete(patientRepository.findPatientById(id));
    }

}
