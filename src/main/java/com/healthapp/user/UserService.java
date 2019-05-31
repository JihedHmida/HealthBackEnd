package com.healthapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Bean
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public UserDetails findUserById(long id) {
        return this.userRepository.findUserById(id);
    }

    public UserDetails findUser(User user) {
        return this.userRepository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }


    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = this.userRepository.findUserByUsername(s);
        if (user == null)
            throw new UsernameNotFoundException("");
        return user;
    }


    public void saveUser(User user) {
        user.setPassword(this.passwordEncoder().encode(user.getPassword()));
        userRepository.save(user);
    }
}
