package com.healthapp.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin( origins = "*",allowedHeaders = "*")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @RequestMapping("/doctors")
    public List<Doctor> getAllDoctors()
    {
        return doctorService.findAll();
    }

    @RequestMapping("/doctors/{id}")
    public Doctor getDoctorById(@PathVariable long id)
    {
        return doctorService.findDoctorById(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/doctors/add")
    public void addDoctor(@RequestBody Doctor doc)
    {
        doctorService.addDoctor(doc);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/doctors/{id}")
    public void updateDoctor(@RequestBody Doctor doc,@PathVariable long id)
    {
        doctorService.updateDoctor(doc,id);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/doctors/{id}")
    public void deleteDoctor(@PathVariable long id )
    {
        doctorService.deleteDoctor(id);
    }
}
