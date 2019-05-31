package com.healthapp.consultation;

import com.healthapp.doctor.Doctor;
import com.healthapp.doctor.DoctorRepository;
import com.healthapp.patient.Patient;
import com.healthapp.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ConsultationService {

    @Autowired
    ConsultationRepository consultationRepository;


    public List<Consultation> findAll() {
        return consultationRepository.findAll();
    }

    public void addConsultation(Consultation consultation) {

        consultationRepository.save(consultation);
    }

    public List<Consultation> findConsultationsByPatientId(long id) {
        return consultationRepository.findConsultationsByPatientId(id);
    }

    public List<Consultation> findConsultationsByDoctorId(long id) {
        return consultationRepository.findConsultationsByDoctorId(id);
    }

    public Consultation findConsultationByID(long id) {
        return consultationRepository.findConsultationById(id);
    }

    public void deleteConsultation(long id) {
        consultationRepository.delete(findConsultationByID(id));
    }

    public void updateConsultation(Consultation consultation, long id) {

        Consultation consultation1ToUpdate = findConsultationByID(id);
        consultation1ToUpdate.setDate(consultation.getDate());
        consultation1ToUpdate.setNote(consultation.getNote());
        consultationRepository.save(consultation1ToUpdate);
    }
}
