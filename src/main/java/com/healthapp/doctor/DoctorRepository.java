package com.healthapp.doctor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    public Doctor findDoctorById(long id);
    public Doctor findDoctorByEmail(String email);
    public List<Doctor> findDoctorsByFirstName(String firstName);


}
