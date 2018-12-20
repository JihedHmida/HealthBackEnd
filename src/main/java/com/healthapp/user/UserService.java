package com.healthapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll()
    {
        return this.userRepository.findAll();
    }

    public void addUser(User user){
        this.userRepository.save(user);
    }

    public User findUser(User user){
        return this.userRepository.findUserByUserNameAndUserPwd(user.getUserName(),user.getUserPwd());
    }

}
