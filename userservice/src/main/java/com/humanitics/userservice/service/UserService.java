package com.humanitics.userservice.service;

import java.util.List;

import com.humanitics.userservice.dto.User;

public interface UserService {
	User saveUser (User user);
	List<User> getAllUser();
	User getUser(String userId);
}
