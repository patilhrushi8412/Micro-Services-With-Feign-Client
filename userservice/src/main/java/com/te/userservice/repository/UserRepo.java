package com.te.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.userservice.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
