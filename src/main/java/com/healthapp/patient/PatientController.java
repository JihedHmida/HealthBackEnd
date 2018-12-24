package com.healthapp.patient;

import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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



    Map<String,String> errors ;
    @SuppressWarnings("Duplicates")
    @RequestMapping(method = RequestMethod.POST,value = "/patient/add")
    public ResponseEntity<Object> addDoctor(@RequestBody @Valid Patient patient, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            errors = new HashMap<>();
            for(FieldError error:bindingResult.getFieldErrors()){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
        }

        Patient p = patientService.findDoctorByEmail (patient.getEmail());
        if(p!=null){
            return new ResponseEntity<>("User Already Exist ",HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(patientService.addPatient(patient),HttpStatus.OK);
    }








    /*
    @RequestMapping(method = RequestMethod.POST,value = "/patient/add")
    public void addPatient(@RequestBody Patient patient)
    {
        patientService.addPatient(patient);
    }
*/
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
