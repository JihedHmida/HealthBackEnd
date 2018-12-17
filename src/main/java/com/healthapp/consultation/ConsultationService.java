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
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientRepository patientRepository;



    public List<Consultation> findAll() {
        return  consultationRepository.findAll();
    }

    public void  addConsultation (){


        Doctor doctor = doctorRepository.findDoctorById(2);
        Patient patient = patientRepository.findPatientById(2);

        Consultation consultation = new Consultation(new Date(12-3-1994),"second",patient,doctor);
        consultationRepository.save(consultation);
    }

    public List<Consultation> findByPatientId(long id)
    {
       return consultationRepository.findConsultationsByPatientId(id);
    }


}
