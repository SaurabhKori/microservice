package com.humanitics.userservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.humanitics.userservice.dto.User;

public interface UserRepo extends JpaRepository<User, String>{

}
