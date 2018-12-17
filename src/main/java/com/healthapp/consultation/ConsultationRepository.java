package com.healthapp.consultation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultationRepository extends JpaRepository <Consultation,Long> {

    public List<Consultation> findConsultationsByPatientId(long id);

}
