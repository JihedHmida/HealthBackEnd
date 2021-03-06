package com.healthapp.consultation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ConsultationController {

    @Autowired
    ConsultationService consultationService;


    @RequestMapping("/consultation")
    public List<Consultation> getAllConsultation() {
        return consultationService.findAll();
    }

    @RequestMapping("/consultation/{id}")
    public Consultation getConsultation(@PathVariable long id) {
        return consultationService.findConsultationByID(id);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/consultation/add")
    public void addConsultation(@RequestBody Consultation consultation) {
        consultationService.addConsultation(consultation);
    }


    @RequestMapping("/consultation/patient{id}")
    public List<Consultation> getConsultationByPatientId(@PathVariable long id) {
        return consultationService.findConsultationsByPatientId(id);
    }

    @RequestMapping("/consultation/doctor{id}")
    public List<Consultation> getConsultationByDoctorId(@PathVariable long id) {
        return consultationService.findConsultationsByDoctorId(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/consultation/{id}")
    public void updateConsultation(@RequestBody Consultation consultation, @PathVariable long id) {
        consultationService.updateConsultation(consultation, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/consultation/{id}")
    public void deleteConsultation(@PathVariable long id) {
        consultationService.deleteConsultation(id);
    }
}
