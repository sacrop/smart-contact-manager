package com.webapplication.webapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapplication.webapp.entities.User;

public interface UserRepository extends JpaRepository<User,Integer>{
    

}
