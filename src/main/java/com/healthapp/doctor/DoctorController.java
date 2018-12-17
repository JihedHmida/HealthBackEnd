package com.healthapp.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @RequestMapping("/doctor")
    public List<Doctor> getAllDoctors()
    {
        return doctorService.findAll();
    }

    @RequestMapping("/doctor/{id}")
    public Doctor getDoctorById(@PathVariable long id)
    {
        return doctorService.findDoctorById(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/doctor")
    public void addDoctor(@RequestBody Doctor doc)
    {
        doctorService.addDoctor(doc);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/doctor/{id}")
    public void updateDoctor(@RequestBody Doctor doc,@PathVariable long id)
    {
        doctorService.updateDoctor(doc,id);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/doctor/{id}")
    public void deleteDoctor(@PathVariable long id )
    {
        doctorService.deleteDoctor(id);
    }
}
