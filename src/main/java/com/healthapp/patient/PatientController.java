package com.healthapp.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @RequestMapping("/patient")
    public List<Patient> getAllPatient()
    {
        return patientService.findAll();
    }

    @RequestMapping("/patient/{id}")
    public Patient getPatientById(@PathVariable long id)
    {
        return patientService.findPatientById(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/patient")
    public void addPatient(@RequestBody Patient patient)
    {
        patientService.addPatient(patient);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/patient/{id}")
    public void updatePatient(@RequestBody Patient patient,@PathVariable long id)
    {
        patientService.updatePatient(patient,id);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/patient/{id}")
    public void deletePatient(@PathVariable long id )
    {
        patientService.deletePatient(id);
    }
}
