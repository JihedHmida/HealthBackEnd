package com.healthapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users")
    public List<User> getusers()
    {
        return this.userService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST ,value="/user")
    public User getUser(@RequestBody User user){
       return  this.userService.findUser(user);

    }
    @RequestMapping("/users/{id}")
    public User getDoctorById(@PathVariable long id)
    {
        return userService.findUserById(id);
    }


}
