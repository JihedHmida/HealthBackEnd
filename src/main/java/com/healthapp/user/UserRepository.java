package com.healthapp.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsernameAndPassword(String name, String pwd);

    User findUserByUsername(String name);

    User findUserById(long id);
}
