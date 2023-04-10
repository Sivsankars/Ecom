package com.consumeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consumeapi.ModelObject.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
