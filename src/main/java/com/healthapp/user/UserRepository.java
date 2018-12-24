package com.healthapp.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findUserByUserNameAndUserPwd(String name,String pwd);


    User findUserByUserId(long id);
}
