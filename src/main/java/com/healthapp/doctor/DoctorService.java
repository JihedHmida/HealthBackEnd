package com.healthapp.doctor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired DoctorRepository doctorRepository;


    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    public Doctor findDoctorByEmail(String email) {
        return doctorRepository.findDoctorByEmail(email);
    }

    public Doctor findDoctorById(long id) {
        return doctorRepository.findDoctorById(id);
    }

    public List<Doctor> findDoctorsByFirstName(String firstName )
    {
        return doctorRepository.findDoctorsByFirstName(firstName);
    }

    public Doctor addDoctor(Doctor doc) {
        return doctorRepository.save(doc);
    }

    @SuppressWarnings("Duplicates")
    public void updateDoctor(Doctor doc, long id) {

        Doctor doctorToUpdate = findDoctorById(id);
        doctorToUpdate.setFirstName(doc.getFirstName());
        doctorToUpdate.setLastName(doc.getLastName());
        doctorToUpdate.setBirthDate(doc.getBirthDate());
        doctorToUpdate.setPhoto(doc.getPhoto());
        doctorToUpdate.setPhone(doc.getPhone());
        doctorToUpdate.getUser().setUserPwd(doc.getUser().getUserPwd());
        doctorToUpdate.getUser().setAdmin(doc.getUser().isAdmin());
        doctorRepository.save(doctorToUpdate);

    }


    public void deleteDoctor(long id) {
        doctorRepository.delete(doctorRepository.findDoctorById(id));
    }

}
