package com.healthapp.doctor;

import com.healthapp.user.UserRepository;
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
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired


    @RequestMapping("/doctors")
    public List<Doctor> getAllDoctors() {
        return doctorService.findAll();
    }

    @RequestMapping("/doctors/{id}")
    public Doctor getDoctorById(@PathVariable long id) {
        return doctorService.findDoctorById(id);
    }


    Map<String, String> errors;

    @SuppressWarnings("Duplicates")
    @RequestMapping(method = RequestMethod.POST, value = "/doctors/add")
    public ResponseEntity<Object> addDoctor(@RequestBody @Valid Doctor doc, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
        }

        Doctor d = doctorService.findDoctorByEmail(doc.getEmail());
        if (d != null) {
            return new ResponseEntity<>("User Already Exist ", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(doctorService.addDoctor(doc), HttpStatus.OK);
    }




    /*
    @RequestMapping(method = RequestMethod.POST,value = "/doctors/add")
    public void addDoctor(@RequestBody Doctor doc)
    {
        doctorService.addDoctor(doc);
    }
    */

    @RequestMapping(method = RequestMethod.PUT, value = "/doctors/{id}")
    public void updateDoctor(@RequestBody Doctor doc, @PathVariable long id) {
        doctorService.updateDoctor(doc, id);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/doctors/{id}")
    public void deleteDoctor(@PathVariable long id) {
        doctorService.deleteDoctor(id);
    }
}
