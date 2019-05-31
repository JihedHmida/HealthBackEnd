package com.healthapp.user;

import com.healthapp.security.JwtResponse;
import com.healthapp.security.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private TokenGenerator tokenGenerator;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public JwtResponse logIn(@RequestBody User user) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
        String token = tokenGenerator.generateToken(userDetails);
        return new JwtResponse(token);
    }

    @RequestMapping(value = "/users")
    public List<User> getusers() {
        return this.userService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public UserDetails getUser(@RequestBody User user) {
        return this.userService.findUser(user);

    }

    @RequestMapping("/users/{id}")
    public UserDetails getUserById(@PathVariable long id) {
        return userService.findUserById(id);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/userAdd")
    public void adduser(@RequestBody User user) {
        userService.saveUser(user);
    }

}
